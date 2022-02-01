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
import androidx.c.a.c;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

final class x
  extends c
  implements View.OnClickListener
{
  private boolean mClosed;
  private final SearchableInfo uP;
  private final WeakHashMap<String, Drawable.ConstantState> uU;
  private final SearchView ve;
  private final SearchManager vo;
  private final Context vp;
  private final int vq;
  int vr;
  private ColorStateList vs;
  private int vt;
  private int vu;
  private int vv;
  private int vw;
  private int vx;
  private int vy;
  
  public x(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout());
    AppMethodBeat.i(241883);
    this.mClosed = false;
    this.vr = 1;
    this.vt = -1;
    this.vu = -1;
    this.vv = -1;
    this.vw = -1;
    this.vx = -1;
    this.vy = -1;
    this.vo = ((SearchManager)this.mContext.getSystemService("search"));
    this.ve = paramSearchView;
    this.uP = paramSearchableInfo;
    this.vq = paramSearchView.getSuggestionCommitIconResId();
    this.vp = paramContext;
    this.uU = paramWeakHashMap;
    AppMethodBeat.o(241883);
  }
  
  private Drawable a(ComponentName paramComponentName)
  {
    AppMethodBeat.i(241905);
    Object localObject = this.mContext.getPackageManager();
    ActivityInfo localActivityInfo;
    int i;
    try
    {
      localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      i = localActivityInfo.getIconResource();
      if (i == 0)
      {
        AppMethodBeat.o(241905);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      AppMethodBeat.o(241905);
      return null;
    }
    localObject = ((PackageManager)localObject).getDrawable(paramComponentName.getPackageName(), i, localActivityInfo.applicationInfo);
    if (localObject == null)
    {
      new StringBuilder("Invalid icon resource ").append(i).append(" for ").append(paramComponentName.flattenToShortString());
      AppMethodBeat.o(241905);
      return null;
    }
    AppMethodBeat.o(241905);
    return localObject;
  }
  
  private static String a(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(241908);
    if (paramInt == -1)
    {
      AppMethodBeat.o(241908);
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      AppMethodBeat.o(241908);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      AppMethodBeat.o(241908);
    }
    return null;
  }
  
  public static String a(Cursor paramCursor, String paramString)
  {
    AppMethodBeat.i(241907);
    paramCursor = a(paramCursor, paramCursor.getColumnIndex(paramString));
    AppMethodBeat.o(241907);
    return paramCursor;
  }
  
  private static void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(241896);
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      AppMethodBeat.o(241896);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
    AppMethodBeat.o(241896);
  }
  
  private static void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241895);
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      AppMethodBeat.o(241895);
      return;
    }
    paramTextView.setVisibility(0);
    AppMethodBeat.o(241895);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(241904);
    if (paramDrawable != null) {
      this.uU.put(paramString, paramDrawable.getConstantState());
    }
    AppMethodBeat.o(241904);
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
    //   93: getfield 93	androidx/appcompat/widget/x:vp	Landroid/content/Context;
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
    AppMethodBeat.i(241890);
    if (paramCursor != null) {}
    for (paramCursor = paramCursor.getExtras(); (paramCursor != null) && (paramCursor.getBoolean("in_progress")); paramCursor = null)
    {
      AppMethodBeat.o(241890);
      return;
    }
    AppMethodBeat.o(241890);
  }
  
  private Drawable c(Uri paramUri)
  {
    AppMethodBeat.i(241911);
    String str = paramUri.getAuthority();
    if (TextUtils.isEmpty(str))
    {
      paramUri = new FileNotFoundException("No authority: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(241911);
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
        AppMethodBeat.o(241911);
        throw paramUri;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramUri = new FileNotFoundException("No package found for authority: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(241911);
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
        AppMethodBeat.o(241911);
        throw paramUri;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramUri = new FileNotFoundException("Single path segment is not a resource ID: ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(241911);
        throw paramUri;
      }
      if (i == 2)
      {
        i = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), localNumberFormatException);
      }
      else
      {
        paramUri = new FileNotFoundException("More than two path segments: ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(241911);
        throw paramUri;
      }
    }
    paramUri = localResources.getDrawable(i);
    AppMethodBeat.o(241911);
    return paramUri;
  }
  
  private Drawable t(String paramString)
  {
    AppMethodBeat.i(241901);
    if ((paramString == null) || (paramString.isEmpty()) || ("0".equals(paramString)))
    {
      AppMethodBeat.o(241901);
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      String str = "android.resource://" + this.vp.getPackageName() + "/" + i;
      Drawable localDrawable2 = u(str);
      if (localDrawable2 != null)
      {
        AppMethodBeat.o(241901);
        return localDrawable2;
      }
      localDrawable2 = a.m(this.vp, i);
      a(str, localDrawable2);
      AppMethodBeat.o(241901);
      return localDrawable2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Drawable localDrawable1 = u(paramString);
      if (localDrawable1 != null)
      {
        AppMethodBeat.o(241901);
        return localDrawable1;
      }
      localDrawable1 = b(Uri.parse(paramString));
      a(paramString, localDrawable1);
      AppMethodBeat.o(241901);
      return localDrawable1;
    }
    catch (Resources.NotFoundException paramString)
    {
      AppMethodBeat.o(241901);
    }
    return null;
  }
  
  private Drawable u(String paramString)
  {
    AppMethodBeat.i(241903);
    paramString = (Drawable.ConstantState)this.uU.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(241903);
      return null;
    }
    paramString = paramString.newDrawable();
    AppMethodBeat.o(241903);
    return paramString;
  }
  
  public final void a(View paramView, Cursor paramCursor)
  {
    Object localObject2 = null;
    AppMethodBeat.i(241893);
    a locala = (a)paramView.getTag();
    if (this.vy != -1) {}
    for (int i = paramCursor.getInt(this.vy);; i = 0)
    {
      if (locala.vz != null)
      {
        paramView = a(paramCursor, this.vt);
        a(locala.vz, paramView);
      }
      Object localObject1;
      if (locala.vA != null)
      {
        localObject1 = a(paramCursor, this.vv);
        if (localObject1 != null)
        {
          if (this.vs == null)
          {
            paramView = new TypedValue();
            this.mContext.getTheme().resolveAttribute(a.a.textColorSearchUrl, paramView, true);
            this.vs = this.mContext.getResources().getColorStateList(paramView.resourceId);
          }
          paramView = new SpannableString((CharSequence)localObject1);
          paramView.setSpan(new TextAppearanceSpan(null, 0, 0, this.vs, null), 0, ((CharSequence)localObject1).length(), 33);
          if (!TextUtils.isEmpty(paramView)) {
            break label357;
          }
          if (locala.vz != null)
          {
            locala.vz.setSingleLine(false);
            locala.vz.setMaxLines(2);
          }
          label207:
          a(locala.vA, paramView);
        }
      }
      else
      {
        if (locala.vB != null)
        {
          ImageView localImageView = locala.vB;
          if (this.vw != -1) {
            break label386;
          }
          paramView = null;
          label241:
          a(localImageView, paramView, 4);
        }
        if (locala.vC != null)
        {
          localObject1 = locala.vC;
          if (this.vx != -1) {
            break label531;
          }
        }
      }
      label386:
      label531:
      for (paramView = localObject2;; paramView = t(paramCursor.getString(this.vx)))
      {
        a((ImageView)localObject1, paramView, 8);
        if ((this.vr != 2) && ((this.vr != 1) || ((i & 0x1) == 0))) {
          break label549;
        }
        locala.vD.setVisibility(0);
        locala.vD.setTag(locala.vz.getText());
        locala.vD.setOnClickListener(this);
        AppMethodBeat.o(241893);
        return;
        paramView = a(paramCursor, this.vu);
        break;
        label357:
        if (locala.vz == null) {
          break label207;
        }
        locala.vz.setSingleLine(true);
        locala.vz.setMaxLines(1);
        break label207;
        localObject1 = t(paramCursor.getString(this.vw));
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label241;
        }
        paramView = this.uP.getSearchActivity();
        String str = paramView.flattenToShortString();
        if (this.uU.containsKey(str))
        {
          paramView = (Drawable.ConstantState)this.uU.get(str);
          if (paramView == null) {}
          for (localObject1 = null;; localObject1 = paramView.newDrawable(this.vp.getResources()))
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
          this.uU.put(str, paramView);
          break;
        }
      }
      label549:
      locala.vD.setVisibility(8);
      AppMethodBeat.o(241893);
      return;
    }
  }
  
  public final void c(Cursor paramCursor)
  {
    AppMethodBeat.i(241891);
    if (this.mClosed)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      AppMethodBeat.o(241891);
      return;
    }
    try
    {
      super.c(paramCursor);
      if (paramCursor != null)
      {
        this.vt = paramCursor.getColumnIndex("suggest_text_1");
        this.vu = paramCursor.getColumnIndex("suggest_text_2");
        this.vv = paramCursor.getColumnIndex("suggest_text_2_url");
        this.vw = paramCursor.getColumnIndex("suggest_icon_1");
        this.vx = paramCursor.getColumnIndex("suggest_icon_2");
        this.vy = paramCursor.getColumnIndex("suggest_flags");
      }
      AppMethodBeat.o(241891);
      return;
    }
    catch (Exception paramCursor)
    {
      AppMethodBeat.o(241891);
    }
  }
  
  public final CharSequence d(Cursor paramCursor)
  {
    AppMethodBeat.i(241897);
    if (paramCursor == null)
    {
      AppMethodBeat.o(241897);
      return null;
    }
    String str = a(paramCursor, "suggest_intent_query");
    if (str != null)
    {
      AppMethodBeat.o(241897);
      return str;
    }
    if (this.uP.shouldRewriteQueryFromData())
    {
      str = a(paramCursor, "suggest_intent_data");
      if (str != null)
      {
        AppMethodBeat.o(241897);
        return str;
      }
    }
    if (this.uP.shouldRewriteQueryFromText())
    {
      paramCursor = a(paramCursor, "suggest_text_1");
      if (paramCursor != null)
      {
        AppMethodBeat.o(241897);
        return paramCursor;
      }
    }
    AppMethodBeat.o(241897);
    return null;
  }
  
  public final Cursor g(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241887);
    if (paramCharSequence == null) {}
    for (paramCharSequence = ""; (this.ve.getVisibility() != 0) || (this.ve.getWindowVisibility() != 0); paramCharSequence = paramCharSequence.toString())
    {
      AppMethodBeat.o(241887);
      return null;
    }
    try
    {
      Object localObject1 = this.uP;
      if (localObject1 == null) {
        paramCharSequence = null;
      }
      while (paramCharSequence != null)
      {
        paramCharSequence.getCount();
        AppMethodBeat.o(241887);
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
      AppMethodBeat.o(241887);
    }
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(241900);
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(241900);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = a(this.mContext, this.fB, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).vz.setText(paramView.toString());
      }
      AppMethodBeat.o(241900);
    }
    return paramViewGroup;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(241898);
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(241898);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = newView(this.mContext, this.fB, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).vz.setText(paramView.toString());
      }
      AppMethodBeat.o(241898);
    }
    return paramViewGroup;
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(241892);
    paramContext = super.newView(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new a(paramContext));
    ((ImageView)paramContext.findViewById(a.f.edit_query)).setImageResource(this.vq);
    AppMethodBeat.o(241892);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(241888);
    super.notifyDataSetChanged();
    b(hK());
    AppMethodBeat.o(241888);
  }
  
  public final void notifyDataSetInvalidated()
  {
    AppMethodBeat.i(241889);
    super.notifyDataSetInvalidated();
    b(hK());
    AppMethodBeat.o(241889);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(241894);
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.ve.setQuery((CharSequence)paramView);
    }
    AppMethodBeat.o(241894);
  }
  
  static final class a
  {
    public final TextView vA;
    public final ImageView vB;
    public final ImageView vC;
    public final ImageView vD;
    public final TextView vz;
    
    public a(View paramView)
    {
      AppMethodBeat.i(241875);
      this.vz = ((TextView)paramView.findViewById(16908308));
      this.vA = ((TextView)paramView.findViewById(16908309));
      this.vB = ((ImageView)paramView.findViewById(16908295));
      this.vC = ((ImageView)paramView.findViewById(16908296));
      this.vD = ((ImageView)paramView.findViewById(a.f.edit_query));
      AppMethodBeat.o(241875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.x
 * JD-Core Version:    0.7.0.1
 */