package androidx.appcompat.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a.a;
import androidx.appcompat.a.f;
import androidx.core.content.a;
import androidx.d.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

final class x
  extends c
  implements View.OnClickListener
{
  private boolean mClosed;
  private final SearchableInfo vL;
  private final WeakHashMap<String, Drawable.ConstantState> vQ;
  private final SearchView wa;
  private final SearchManager wj;
  private final Context wk;
  private final int wl;
  int wm;
  private ColorStateList wn;
  private int wo;
  private int wp;
  private int wq;
  private int wr;
  private int ws;
  private int wt;
  
  public x(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout());
    AppMethodBeat.i(199791);
    this.mClosed = false;
    this.wm = 1;
    this.wo = -1;
    this.wp = -1;
    this.wq = -1;
    this.wr = -1;
    this.ws = -1;
    this.wt = -1;
    this.wj = ((SearchManager)this.mContext.getSystemService("search"));
    this.wa = paramSearchView;
    this.vL = paramSearchableInfo;
    this.wl = paramSearchView.getSuggestionCommitIconResId();
    this.wk = paramContext;
    this.vQ = paramWeakHashMap;
    AppMethodBeat.o(199791);
  }
  
  private Drawable a(ComponentName paramComponentName)
  {
    AppMethodBeat.i(199883);
    Object localObject = this.mContext.getPackageManager();
    ActivityInfo localActivityInfo;
    int i;
    try
    {
      localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      i = localActivityInfo.getIconResource();
      if (i == 0)
      {
        AppMethodBeat.o(199883);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      AppMethodBeat.o(199883);
      return null;
    }
    localObject = ((PackageManager)localObject).getDrawable(paramComponentName.getPackageName(), i, localActivityInfo.applicationInfo);
    if (localObject == null)
    {
      new StringBuilder("Invalid icon resource ").append(i).append(" for ").append(paramComponentName.flattenToShortString());
      AppMethodBeat.o(199883);
      return null;
    }
    AppMethodBeat.o(199883);
    return localObject;
  }
  
  private static String a(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(199934);
    if (paramInt == -1)
    {
      AppMethodBeat.o(199934);
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      AppMethodBeat.o(199934);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      AppMethodBeat.o(199934);
    }
    return null;
  }
  
  public static String a(Cursor paramCursor, String paramString)
  {
    AppMethodBeat.i(199891);
    paramCursor = a(paramCursor, paramCursor.getColumnIndex(paramString));
    AppMethodBeat.o(199891);
    return paramCursor;
  }
  
  private static void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(199819);
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      AppMethodBeat.o(199819);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
    AppMethodBeat.o(199819);
  }
  
  private static void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199808);
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      AppMethodBeat.o(199808);
      return;
    }
    paramTextView.setVisibility(0);
    AppMethodBeat.o(199808);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(199871);
    if (paramDrawable != null) {
      this.vQ.put(paramString, paramDrawable.getConstantState());
    }
    AppMethodBeat.o(199871);
  }
  
  /* Error */
  private Drawable b(Uri paramUri)
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 226
    //   7: aload_1
    //   8: invokevirtual 231	android/net/Uri:getScheme	()Ljava/lang/String;
    //   11: invokevirtual 237	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifeq +76 -> 92
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 240	androidx/appcompat/widget/x:c	(Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;
    //   24: astore_3
    //   25: ldc 224
    //   27: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_3
    //   31: areturn
    //   32: astore_3
    //   33: new 219	java/io/FileNotFoundException
    //   36: dup
    //   37: ldc 242
    //   39: aload_1
    //   40: invokestatic 246	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokevirtual 250	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokespecial 251	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   49: astore_3
    //   50: ldc 224
    //   52: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_3
    //   56: athrow
    //   57: astore_3
    //   58: new 136	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 253
    //   64: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_1
    //   68: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: ldc_w 258
    //   74: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_3
    //   78: invokevirtual 261	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   81: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc 224
    //   87: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aconst_null
    //   91: areturn
    //   92: aload_0
    //   93: getfield 93	androidx/appcompat/widget/x:wk	Landroid/content/Context;
    //   96: invokevirtual 265	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   99: aload_1
    //   100: invokevirtual 271	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   103: astore_3
    //   104: aload_3
    //   105: ifnonnull +28 -> 133
    //   108: new 219	java/io/FileNotFoundException
    //   111: dup
    //   112: ldc_w 273
    //   115: aload_1
    //   116: invokestatic 246	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 250	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokespecial 251	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   125: astore_3
    //   126: ldc 224
    //   128: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_3
    //   132: athrow
    //   133: aload_3
    //   134: aconst_null
    //   135: invokestatic 277	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   138: astore 4
    //   140: aload_3
    //   141: invokevirtual 283	java/io/InputStream:close	()V
    //   144: ldc 224
    //   146: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 4
    //   151: areturn
    //   152: astore_3
    //   153: new 136	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 285
    //   160: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_1
    //   164: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: goto -24 -> 144
    //   171: astore 4
    //   173: aload_3
    //   174: invokevirtual 283	java/io/InputStream:close	()V
    //   177: ldc 224
    //   179: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload 4
    //   184: athrow
    //   185: astore_3
    //   186: new 136	java/lang/StringBuilder
    //   189: dup
    //   190: ldc_w 285
    //   193: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: aload_1
    //   197: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: goto -24 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	x
    //   0	204	1	paramUri	Uri
    //   14	2	2	bool	boolean
    //   24	7	3	localDrawable1	Drawable
    //   32	1	3	localNotFoundException	Resources.NotFoundException
    //   49	7	3	localFileNotFoundException1	FileNotFoundException
    //   57	21	3	localFileNotFoundException2	FileNotFoundException
    //   103	38	3	localObject1	Object
    //   152	22	3	localIOException1	java.io.IOException
    //   185	1	3	localIOException2	java.io.IOException
    //   138	12	4	localDrawable2	Drawable
    //   171	12	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	25	32	android/content/res/Resources$NotFoundException
    //   5	15	57	java/io/FileNotFoundException
    //   19	25	57	java/io/FileNotFoundException
    //   33	57	57	java/io/FileNotFoundException
    //   92	104	57	java/io/FileNotFoundException
    //   108	133	57	java/io/FileNotFoundException
    //   140	144	57	java/io/FileNotFoundException
    //   153	168	57	java/io/FileNotFoundException
    //   173	177	57	java/io/FileNotFoundException
    //   177	185	57	java/io/FileNotFoundException
    //   186	201	57	java/io/FileNotFoundException
    //   140	144	152	java/io/IOException
    //   133	140	171	finally
    //   173	177	185	java/io/IOException
  }
  
  private static void b(Cursor paramCursor)
  {
    AppMethodBeat.i(199801);
    if (paramCursor != null) {}
    for (paramCursor = paramCursor.getExtras(); (paramCursor != null) && (paramCursor.getBoolean("in_progress")); paramCursor = null)
    {
      AppMethodBeat.o(199801);
      return;
    }
    AppMethodBeat.o(199801);
  }
  
  private Drawable c(Uri paramUri)
  {
    AppMethodBeat.i(199949);
    String str = paramUri.getAuthority();
    if (TextUtils.isEmpty(str))
    {
      paramUri = new FileNotFoundException("No authority: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(199949);
      throw paramUri;
    }
    Resources localResources;
    List localList;
    try
    {
      localResources = this.mContext.getPackageManager().getResourcesForApplication(str);
      localList = paramUri.getPathSegments();
      if (localList == null)
      {
        paramUri = new FileNotFoundException("No path: ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(199949);
        throw paramUri;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramUri = new FileNotFoundException("No package found for authority: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(199949);
      throw paramUri;
    }
    int i = localList.size();
    if (i == 1) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)localList.get(0));
        if (i != 0) {
          break;
        }
        paramUri = new FileNotFoundException("No resource found for: ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(199949);
        throw paramUri;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramUri = new FileNotFoundException("Single path segment is not a resource ID: ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(199949);
        throw paramUri;
      }
      if (i == 2)
      {
        i = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), localNumberFormatException);
      }
      else
      {
        paramUri = new FileNotFoundException("More than two path segments: ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(199949);
        throw paramUri;
      }
    }
    paramUri = localResources.getDrawable(i);
    AppMethodBeat.o(199949);
    return paramUri;
  }
  
  private Drawable u(String paramString)
  {
    AppMethodBeat.i(199833);
    if ((paramString == null) || (paramString.isEmpty()) || ("0".equals(paramString)))
    {
      AppMethodBeat.o(199833);
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      String str = "android.resource://" + this.wk.getPackageName() + "/" + i;
      Drawable localDrawable2 = x(str);
      if (localDrawable2 != null)
      {
        AppMethodBeat.o(199833);
        return localDrawable2;
      }
      localDrawable2 = a.m(this.wk, i);
      a(str, localDrawable2);
      AppMethodBeat.o(199833);
      return localDrawable2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Drawable localDrawable1 = x(paramString);
      if (localDrawable1 != null)
      {
        AppMethodBeat.o(199833);
        return localDrawable1;
      }
      localDrawable1 = b(Uri.parse(paramString));
      a(paramString, localDrawable1);
      AppMethodBeat.o(199833);
      return localDrawable1;
    }
    catch (Resources.NotFoundException paramString)
    {
      AppMethodBeat.o(199833);
    }
    return null;
  }
  
  private Drawable x(String paramString)
  {
    AppMethodBeat.i(199860);
    paramString = (Drawable.ConstantState)this.vQ.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(199860);
      return null;
    }
    paramString = paramString.newDrawable();
    AppMethodBeat.o(199860);
    return paramString;
  }
  
  public final void a(View paramView, Cursor paramCursor)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200019);
    a locala = (a)paramView.getTag();
    if (this.wt != -1) {}
    for (int i = paramCursor.getInt(this.wt);; i = 0)
    {
      if (locala.wv != null)
      {
        paramView = a(paramCursor, this.wo);
        a(locala.wv, paramView);
      }
      Object localObject1;
      if (locala.ww != null)
      {
        localObject1 = a(paramCursor, this.wq);
        if (localObject1 != null)
        {
          if (this.wn == null)
          {
            paramView = new TypedValue();
            this.mContext.getTheme().resolveAttribute(a.a.textColorSearchUrl, paramView, true);
            this.wn = this.mContext.getResources().getColorStateList(paramView.resourceId);
          }
          paramView = new SpannableString((CharSequence)localObject1);
          paramView.setSpan(new TextAppearanceSpan(null, 0, 0, this.wn, null), 0, ((CharSequence)localObject1).length(), 33);
          if (!TextUtils.isEmpty(paramView)) {
            break label357;
          }
          if (locala.wv != null)
          {
            locala.wv.setSingleLine(false);
            locala.wv.setMaxLines(2);
          }
          label207:
          a(locala.ww, paramView);
        }
      }
      else
      {
        if (locala.wx != null)
        {
          ImageView localImageView = locala.wx;
          if (this.wr != -1) {
            break label386;
          }
          paramView = null;
          label241:
          a(localImageView, paramView, 4);
        }
        if (locala.wy != null)
        {
          localObject1 = locala.wy;
          if (this.ws != -1) {
            break label531;
          }
        }
      }
      label386:
      label531:
      for (paramView = localObject2;; paramView = u(paramCursor.getString(this.ws)))
      {
        a((ImageView)localObject1, paramView, 8);
        if ((this.wm != 2) && ((this.wm != 1) || ((i & 0x1) == 0))) {
          break label549;
        }
        locala.wz.setVisibility(0);
        locala.wz.setTag(locala.wv.getText());
        locala.wz.setOnClickListener(this);
        AppMethodBeat.o(200019);
        return;
        paramView = a(paramCursor, this.wp);
        break;
        label357:
        if (locala.wv == null) {
          break label207;
        }
        locala.wv.setSingleLine(true);
        locala.wv.setMaxLines(1);
        break label207;
        localObject1 = u(paramCursor.getString(this.wr));
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label241;
        }
        paramView = this.vL.getSearchActivity();
        String str = paramView.flattenToShortString();
        if (this.vQ.containsKey(str))
        {
          paramView = (Drawable.ConstantState)this.vQ.get(str);
          if (paramView == null) {}
          for (localObject1 = null;; localObject1 = paramView.newDrawable(this.wk.getResources()))
          {
            paramView = (View)localObject1;
            if (localObject1 != null) {
              break;
            }
            paramView = this.mContext.getPackageManager().getDefaultActivityIcon();
            break;
          }
        }
        localObject1 = a(paramView);
        if (localObject1 == null) {}
        for (paramView = null;; paramView = ((Drawable)localObject1).getConstantState())
        {
          this.vQ.put(str, paramView);
          break;
        }
      }
      label549:
      locala.wz.setVisibility(8);
      AppMethodBeat.o(200019);
      return;
    }
  }
  
  public final void c(Cursor paramCursor)
  {
    AppMethodBeat.i(199993);
    if (this.mClosed)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      AppMethodBeat.o(199993);
      return;
    }
    try
    {
      super.c(paramCursor);
      if (paramCursor != null)
      {
        this.wo = paramCursor.getColumnIndex("suggest_text_1");
        this.wp = paramCursor.getColumnIndex("suggest_text_2");
        this.wq = paramCursor.getColumnIndex("suggest_text_2_url");
        this.wr = paramCursor.getColumnIndex("suggest_icon_1");
        this.ws = paramCursor.getColumnIndex("suggest_icon_2");
        this.wt = paramCursor.getColumnIndex("suggest_flags");
      }
      AppMethodBeat.o(199993);
      return;
    }
    catch (Exception paramCursor)
    {
      AppMethodBeat.o(199993);
    }
  }
  
  public final CharSequence d(Cursor paramCursor)
  {
    AppMethodBeat.i(200036);
    if (paramCursor == null)
    {
      AppMethodBeat.o(200036);
      return null;
    }
    String str = a(paramCursor, "suggest_intent_query");
    if (str != null)
    {
      AppMethodBeat.o(200036);
      return str;
    }
    if (this.vL.shouldRewriteQueryFromData())
    {
      str = a(paramCursor, "suggest_intent_data");
      if (str != null)
      {
        AppMethodBeat.o(200036);
        return str;
      }
    }
    if (this.vL.shouldRewriteQueryFromText())
    {
      paramCursor = a(paramCursor, "suggest_text_1");
      if (paramCursor != null)
      {
        AppMethodBeat.o(200036);
        return paramCursor;
      }
    }
    AppMethodBeat.o(200036);
    return null;
  }
  
  public final Cursor g(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199969);
    if (paramCharSequence == null) {}
    for (paramCharSequence = ""; (this.wa.getVisibility() != 0) || (this.wa.getWindowVisibility() != 0); paramCharSequence = paramCharSequence.toString())
    {
      AppMethodBeat.o(199969);
      return null;
    }
    try
    {
      Object localObject1 = this.vL;
      if (localObject1 == null) {
        paramCharSequence = null;
      }
      while (paramCharSequence != null)
      {
        paramCharSequence.getCount();
        AppMethodBeat.o(199969);
        return paramCharSequence;
        Object localObject2 = ((SearchableInfo)localObject1).getSuggestAuthority();
        if (localObject2 == null)
        {
          paramCharSequence = null;
        }
        else
        {
          localObject2 = new Uri.Builder().scheme("content").authority((String)localObject2).query("").fragment("");
          String str = ((SearchableInfo)localObject1).getSuggestPath();
          if (str != null) {
            ((Uri.Builder)localObject2).appendEncodedPath(str);
          }
          ((Uri.Builder)localObject2).appendPath("search_suggest_query");
          str = ((SearchableInfo)localObject1).getSuggestSelection();
          if (str != null)
          {
            localObject1 = new String[1];
            localObject1[0] = paramCharSequence;
          }
          for (paramCharSequence = (CharSequence)localObject1;; paramCharSequence = null)
          {
            ((Uri.Builder)localObject2).appendQueryParameter("limit", "50");
            localObject1 = ((Uri.Builder)localObject2).build();
            paramCharSequence = this.mContext.getContentResolver().query((Uri)localObject1, null, str, paramCharSequence, null);
            break;
            ((Uri.Builder)localObject2).appendPath(paramCharSequence);
          }
        }
      }
      return null;
    }
    catch (RuntimeException paramCharSequence)
    {
      AppMethodBeat.o(199969);
    }
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200055);
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(200055);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = a(this.mContext, this.gw, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).wv.setText(paramView.toString());
      }
      AppMethodBeat.o(200055);
    }
    return paramViewGroup;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200045);
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(200045);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = newView(this.mContext, this.gw, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).wv.setText(paramView.toString());
      }
      AppMethodBeat.o(200045);
    }
    return paramViewGroup;
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200002);
    paramContext = super.newView(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new a(paramContext));
    ((ImageView)paramContext.findViewById(a.f.edit_query)).setImageResource(this.wl);
    AppMethodBeat.o(200002);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(199977);
    super.notifyDataSetChanged();
    b(Fv());
    AppMethodBeat.o(199977);
  }
  
  public final void notifyDataSetInvalidated()
  {
    AppMethodBeat.i(199985);
    super.notifyDataSetInvalidated();
    b(Fv());
    AppMethodBeat.o(199985);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200027);
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.wa.setQuery((CharSequence)paramView);
    }
    AppMethodBeat.o(200027);
  }
  
  static final class a
  {
    public final TextView wv;
    public final TextView ww;
    public final ImageView wx;
    public final ImageView wy;
    public final ImageView wz;
    
    public a(View paramView)
    {
      AppMethodBeat.i(199344);
      this.wv = ((TextView)paramView.findViewById(16908308));
      this.ww = ((TextView)paramView.findViewById(16908309));
      this.wx = ((ImageView)paramView.findViewById(16908295));
      this.wy = ((ImageView)paramView.findViewById(16908296));
      this.wz = ((ImageView)paramView.findViewById(a.f.edit_query));
      AppMethodBeat.o(199344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.x
 * JD-Core Version:    0.7.0.1
 */