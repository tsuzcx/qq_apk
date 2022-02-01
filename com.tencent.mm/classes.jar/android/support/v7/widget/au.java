package android.support.v7.widget;

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
import android.support.v4.content.b;
import android.support.v4.widget.o;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

final class au
  extends o
  implements View.OnClickListener
{
  private final WeakHashMap<String, Drawable.ConstantState> atD;
  private final SearchView atN;
  private final SearchableInfo aty;
  private final SearchManager auJ = (SearchManager)this.mContext.getSystemService("search");
  private final Context auK;
  private final int auL;
  int auM = 1;
  private ColorStateList auN;
  private int auO = -1;
  private int auP = -1;
  private int auQ = -1;
  private int auR = -1;
  private int auS = -1;
  private int auT = -1;
  private boolean mClosed = false;
  
  public au(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout());
    this.atN = paramSearchView;
    this.aty = paramSearchableInfo;
    this.auL = paramSearchView.getSuggestionCommitIconResId();
    this.auK = paramContext;
    this.atD = paramWeakHashMap;
  }
  
  private Drawable G(String paramString)
  {
    Object localObject1;
    if ((paramString == null) || (paramString.isEmpty()) || ("0".equals(paramString))) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        int i = Integer.parseInt(paramString);
        String str = "android.resource://" + this.auK.getPackageName() + "/" + i;
        localDrawable = H(str);
        localObject1 = localDrawable;
        if (localDrawable == null)
        {
          localObject1 = b.l(this.auK, i);
          a(str, (Drawable)localObject1);
          return localObject1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Drawable localDrawable = H(paramString);
        Object localObject2 = localDrawable;
        if (localDrawable == null)
        {
          localObject2 = d(Uri.parse(paramString));
          a(paramString, (Drawable)localObject2);
          return localObject2;
        }
      }
      catch (Resources.NotFoundException paramString) {}
    }
    return null;
  }
  
  private Drawable H(String paramString)
  {
    paramString = (Drawable.ConstantState)this.atD.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.newDrawable();
  }
  
  private static String a(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor) {}
    return null;
  }
  
  public static String a(Cursor paramCursor, String paramString)
  {
    return a(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private static void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.atD.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private static void b(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (paramCursor = paramCursor.getExtras();; paramCursor = null)
    {
      if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
      return;
    }
  }
  
  private static void b(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private Drawable d(Uri paramUri)
  {
    try
    {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (bool) {
        try
        {
          Drawable localDrawable1 = e(paramUri);
          return localDrawable1;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          throw new FileNotFoundException("Resource does not exist: ".concat(String.valueOf(paramUri)));
        }
      }
      localInputStream = this.auK.getContentResolver().openInputStream(paramUri);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      new StringBuilder("Icon not found: ").append(paramUri).append(", ").append(localFileNotFoundException.getMessage());
      return null;
    }
    InputStream localInputStream;
    if (localInputStream == null) {
      throw new FileNotFoundException("Failed to open ".concat(String.valueOf(paramUri)));
    }
    try
    {
      Drawable localDrawable2 = Drawable.createFromStream(localInputStream, null);
      try
      {
        localInputStream.close();
        return localDrawable2;
      }
      catch (IOException localIOException1)
      {
        new StringBuilder("Error closing icon stream for ").append(paramUri);
        return localDrawable2;
      }
      try
      {
        localIOException1.close();
        throw localObject;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          new StringBuilder("Error closing icon stream for ").append(paramUri);
        }
      }
    }
    finally {}
  }
  
  private Drawable e(Uri paramUri)
  {
    String str = paramUri.getAuthority();
    if (TextUtils.isEmpty(str)) {
      throw new FileNotFoundException("No authority: ".concat(String.valueOf(paramUri)));
    }
    Resources localResources;
    List localList;
    try
    {
      localResources = this.mContext.getPackageManager().getResourcesForApplication(str);
      localList = paramUri.getPathSegments();
      if (localList == null) {
        throw new FileNotFoundException("No path: ".concat(String.valueOf(paramUri)));
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new FileNotFoundException("No package found for authority: ".concat(String.valueOf(paramUri)));
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
        throw new FileNotFoundException("No resource found for: ".concat(String.valueOf(paramUri)));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new FileNotFoundException("Single path segment is not a resource ID: ".concat(String.valueOf(paramUri)));
      }
      if (i == 2) {
        i = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), localNumberFormatException);
      } else {
        throw new FileNotFoundException("More than two path segments: ".concat(String.valueOf(paramUri)));
      }
    }
    return localResources.getDrawable(i);
  }
  
  private Drawable getActivityIcon(ComponentName paramComponentName)
  {
    Object localObject = this.mContext.getPackageManager();
    try
    {
      ActivityInfo localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      int i = localActivityInfo.getIconResource();
      if (i == 0) {
        return null;
      }
      localObject = ((PackageManager)localObject).getDrawable(paramComponentName.getPackageName(), i, localActivityInfo.applicationInfo);
      if (localObject == null)
      {
        new StringBuilder("Invalid icon resource ").append(i).append(" for ").append(paramComponentName.flattenToShortString());
        return null;
      }
      return localObject;
    }
    catch (PackageManager.NameNotFoundException paramComponentName) {}
    return null;
  }
  
  public final void a(View paramView, Cursor paramCursor)
  {
    Object localObject2 = null;
    a locala = (a)paramView.getTag();
    if (this.auT != -1) {}
    for (int i = paramCursor.getInt(this.auT);; i = 0)
    {
      if (locala.auU != null)
      {
        paramView = a(paramCursor, this.auO);
        b(locala.auU, paramView);
      }
      Object localObject1;
      if (locala.auV != null)
      {
        localObject1 = a(paramCursor, this.auQ);
        if (localObject1 != null)
        {
          if (this.auN == null)
          {
            paramView = new TypedValue();
            this.mContext.getTheme().resolveAttribute(2130969561, paramView, true);
            this.auN = this.mContext.getResources().getColorStateList(paramView.resourceId);
          }
          paramView = new SpannableString((CharSequence)localObject1);
          paramView.setSpan(new TextAppearanceSpan(null, 0, 0, this.auN, null), 0, ((CharSequence)localObject1).length(), 33);
          if (!TextUtils.isEmpty(paramView)) {
            break label345;
          }
          if (locala.auU != null)
          {
            locala.auU.setSingleLine(false);
            locala.auU.setMaxLines(2);
          }
          label201:
          b(locala.auV, paramView);
        }
      }
      else
      {
        if (locala.auW != null)
        {
          ImageView localImageView = locala.auW;
          if (this.auR != -1) {
            break label374;
          }
          paramView = null;
          label235:
          a(localImageView, paramView, 4);
        }
        if (locala.auX != null)
        {
          localObject1 = locala.auX;
          if (this.auS != -1) {
            break label519;
          }
        }
      }
      label519:
      for (paramView = localObject2;; paramView = G(paramCursor.getString(this.auS)))
      {
        a((ImageView)localObject1, paramView, 8);
        if ((this.auM != 2) && ((this.auM != 1) || ((i & 0x1) == 0))) {
          break label537;
        }
        locala.auY.setVisibility(0);
        locala.auY.setTag(locala.auU.getText());
        locala.auY.setOnClickListener(this);
        return;
        paramView = a(paramCursor, this.auP);
        break;
        label345:
        if (locala.auU == null) {
          break label201;
        }
        locala.auU.setSingleLine(true);
        locala.auU.setMaxLines(1);
        break label201;
        label374:
        localObject1 = G(paramCursor.getString(this.auR));
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label235;
        }
        paramView = this.aty.getSearchActivity();
        String str = paramView.flattenToShortString();
        if (this.atD.containsKey(str))
        {
          paramView = (Drawable.ConstantState)this.atD.get(str);
          if (paramView == null) {}
          for (localObject1 = null;; localObject1 = paramView.newDrawable(this.auK.getResources()))
          {
            paramView = (View)localObject1;
            if (localObject1 != null) {
              break;
            }
            paramView = this.mContext.getPackageManager().getDefaultActivityIcon();
            break;
          }
        }
        localObject1 = getActivityIcon(paramView);
        if (localObject1 == null) {}
        for (paramView = null;; paramView = ((Drawable)localObject1).getConstantState())
        {
          this.atD.put(str, paramView);
          break;
        }
      }
      label537:
      locala.auY.setVisibility(8);
      return;
    }
  }
  
  public final void changeCursor(Cursor paramCursor)
  {
    if (this.mClosed) {
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    for (;;)
    {
      return;
      try
      {
        super.changeCursor(paramCursor);
        if (paramCursor != null)
        {
          this.auO = paramCursor.getColumnIndex("suggest_text_1");
          this.auP = paramCursor.getColumnIndex("suggest_text_2");
          this.auQ = paramCursor.getColumnIndex("suggest_text_2_url");
          this.auR = paramCursor.getColumnIndex("suggest_icon_1");
          this.auS = paramCursor.getColumnIndex("suggest_icon_2");
          this.auT = paramCursor.getColumnIndex("suggest_flags");
          return;
        }
      }
      catch (Exception paramCursor) {}
    }
  }
  
  public final CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      do
      {
        return null;
        String str = a(paramCursor, "suggest_intent_query");
        if (str != null) {
          return str;
        }
        if (this.aty.shouldRewriteQueryFromData())
        {
          str = a(paramCursor, "suggest_intent_data");
          if (str != null) {
            return str;
          }
        }
      } while (!this.aty.shouldRewriteQueryFromText());
      paramCursor = a(paramCursor, "suggest_text_1");
    } while (paramCursor == null);
    return paramCursor;
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = newDropDownView(this.mContext, this.Qs, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).auU.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = newView(this.mContext, this.Qs, paramViewGroup);
      if (paramViewGroup != null) {
        ((a)paramViewGroup.getTag()).auU.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = super.newView(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new a(paramContext));
    ((ImageView)paramContext.findViewById(2131299261)).setImageResource(this.auL);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    b(getCursor());
  }
  
  public final void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    b(getCursor());
  }
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.atN.setQuery((CharSequence)paramView);
    }
  }
  
  public final Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = ""; (this.atN.getVisibility() != 0) || (this.atN.getWindowVisibility() != 0); paramCharSequence = paramCharSequence.toString()) {
      return null;
    }
    try
    {
      Object localObject1 = this.aty;
      if (localObject1 == null) {
        paramCharSequence = null;
      }
      while (paramCharSequence != null)
      {
        paramCharSequence.getCount();
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
    catch (RuntimeException paramCharSequence) {}
  }
  
  static final class a
  {
    public final TextView auU;
    public final TextView auV;
    public final ImageView auW;
    public final ImageView auX;
    public final ImageView auY;
    
    public a(View paramView)
    {
      this.auU = ((TextView)paramView.findViewById(16908308));
      this.auV = ((TextView)paramView.findViewById(16908309));
      this.auW = ((ImageView)paramView.findViewById(16908295));
      this.auX = ((ImageView)paramView.findViewById(16908296));
      this.auY = ((ImageView)paramView.findViewById(2131299261));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.au
 * JD-Core Version:    0.7.0.1
 */