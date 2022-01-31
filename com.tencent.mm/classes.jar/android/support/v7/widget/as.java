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
import android.support.v4.widget.f;
import android.support.v4.widget.m;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
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

final class as
  extends m
  implements View.OnClickListener
{
  private final SearchableInfo ajJ;
  private final WeakHashMap<String, Drawable.ConstantState> ajO;
  private final SearchView ajY;
  private final SearchManager akR = (SearchManager)this.mContext.getSystemService("search");
  private final Context akS;
  private final int akT;
  int akU = 1;
  private ColorStateList akV;
  private int akW = -1;
  private int akX = -1;
  private int akY = -1;
  private int akZ = -1;
  private int ala = -1;
  private int alb = -1;
  private boolean mClosed = false;
  
  public as(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout());
    this.ajY = paramSearchView;
    this.ajJ = paramSearchableInfo;
    this.akT = paramSearchView.getSuggestionCommitIconResId();
    this.akS = paramContext;
    this.ajO = paramWeakHashMap;
  }
  
  private Drawable S(String paramString)
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
        String str = "android.resource://" + this.akS.getPackageName() + "/" + i;
        localDrawable = T(str);
        localObject1 = localDrawable;
        if (localDrawable == null)
        {
          localObject1 = b.g(this.akS, i);
          a(str, (Drawable)localObject1);
          return localObject1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Drawable localDrawable = T(paramString);
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
  
  private Drawable T(String paramString)
  {
    paramString = (Drawable.ConstantState)this.ajO.get(paramString);
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
  
  private static void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.ajO.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private static void c(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (paramCursor = paramCursor.getExtras();; paramCursor = null)
    {
      if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
      return;
    }
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
          throw new FileNotFoundException("Resource does not exist: " + paramUri);
        }
      }
      localInputStream = this.akS.getContentResolver().openInputStream(paramUri);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      new StringBuilder("Icon not found: ").append(paramUri).append(", ").append(localFileNotFoundException.getMessage());
      return null;
    }
    InputStream localInputStream;
    if (localInputStream == null) {
      throw new FileNotFoundException("Failed to open " + paramUri);
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
      throw new FileNotFoundException("No authority: " + paramUri);
    }
    Resources localResources;
    List localList;
    try
    {
      localResources = this.mContext.getPackageManager().getResourcesForApplication(str);
      localList = paramUri.getPathSegments();
      if (localList == null) {
        throw new FileNotFoundException("No path: " + paramUri);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new FileNotFoundException("No package found for authority: " + paramUri);
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
        throw new FileNotFoundException("No resource found for: " + paramUri);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new FileNotFoundException("Single path segment is not a resource ID: " + paramUri);
      }
      if (i == 2) {
        i = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), localNumberFormatException);
      } else {
        throw new FileNotFoundException("More than two path segments: " + paramUri);
      }
    }
    return localResources.getDrawable(i);
  }
  
  private Drawable getActivityIcon(ComponentName paramComponentName)
  {
    Object localObject = this.mContext.getPackageManager();
    ActivityInfo localActivityInfo;
    int i;
    try
    {
      localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      i = localActivityInfo.getIconResource();
      if (i == 0) {
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      paramComponentName.toString();
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
  
  public final void a(View paramView, Cursor paramCursor)
  {
    Object localObject2 = null;
    as.a locala = (as.a)paramView.getTag();
    if (this.alb != -1) {}
    for (int i = paramCursor.getInt(this.alb);; i = 0)
    {
      if (locala.alc != null)
      {
        paramView = a(paramCursor, this.akW);
        a(locala.alc, paramView);
      }
      Object localObject1;
      if (locala.ald != null)
      {
        localObject1 = a(paramCursor, this.akY);
        if (localObject1 != null)
        {
          if (this.akV == null)
          {
            paramView = new TypedValue();
            this.mContext.getTheme().resolveAttribute(a.a.textColorSearchUrl, paramView, true);
            this.akV = this.mContext.getResources().getColorStateList(paramView.resourceId);
          }
          paramView = new SpannableString((CharSequence)localObject1);
          paramView.setSpan(new TextAppearanceSpan(null, 0, 0, this.akV, null), 0, ((CharSequence)localObject1).length(), 33);
          if (!TextUtils.isEmpty(paramView)) {
            break label345;
          }
          if (locala.alc != null)
          {
            locala.alc.setSingleLine(false);
            locala.alc.setMaxLines(2);
          }
          label201:
          a(locala.ald, paramView);
        }
      }
      else
      {
        if (locala.ale != null)
        {
          ImageView localImageView = locala.ale;
          if (this.akZ != -1) {
            break label374;
          }
          paramView = null;
          label235:
          a(localImageView, paramView, 4);
        }
        if (locala.alf != null)
        {
          localObject1 = locala.alf;
          if (this.ala != -1) {
            break label519;
          }
        }
      }
      label519:
      for (paramView = localObject2;; paramView = S(paramCursor.getString(this.ala)))
      {
        a((ImageView)localObject1, paramView, 8);
        if ((this.akU != 2) && ((this.akU != 1) || ((i & 0x1) == 0))) {
          break label537;
        }
        locala.alg.setVisibility(0);
        locala.alg.setTag(locala.alc.getText());
        locala.alg.setOnClickListener(this);
        return;
        paramView = a(paramCursor, this.akX);
        break;
        label345:
        if (locala.alc == null) {
          break label201;
        }
        locala.alc.setSingleLine(true);
        locala.alc.setMaxLines(1);
        break label201;
        label374:
        localObject1 = S(paramCursor.getString(this.akZ));
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label235;
        }
        paramView = this.ajJ.getSearchActivity();
        String str = paramView.flattenToShortString();
        if (this.ajO.containsKey(str))
        {
          paramView = (Drawable.ConstantState)this.ajO.get(str);
          if (paramView == null) {}
          for (localObject1 = null;; localObject1 = paramView.newDrawable(this.akS.getResources()))
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
          this.ajO.put(str, paramView);
          break;
        }
      }
      label537:
      locala.alg.setVisibility(8);
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
          this.akW = paramCursor.getColumnIndex("suggest_text_1");
          this.akX = paramCursor.getColumnIndex("suggest_text_2");
          this.akY = paramCursor.getColumnIndex("suggest_text_2_url");
          this.akZ = paramCursor.getColumnIndex("suggest_icon_1");
          this.ala = paramCursor.getColumnIndex("suggest_icon_2");
          this.alb = paramCursor.getColumnIndex("suggest_flags");
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
        if (this.ajJ.shouldRewriteQueryFromData())
        {
          str = a(paramCursor, "suggest_intent_data");
          if (str != null) {
            return str;
          }
        }
      } while (!this.ajJ.shouldRewriteQueryFromText());
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
      paramViewGroup = newDropDownView(this.mContext, this.JM, paramViewGroup);
      if (paramViewGroup != null) {
        ((as.a)paramViewGroup.getTag()).alc.setText(paramView.toString());
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
      paramViewGroup = newView(this.mContext, this.JM, paramViewGroup);
      if (paramViewGroup != null) {
        ((as.a)paramViewGroup.getTag()).alc.setText(paramView.toString());
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
    paramContext.setTag(new as.a(paramContext));
    ((ImageView)paramContext.findViewById(a.f.edit_query)).setImageResource(this.akT);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    c(this.JM);
  }
  
  public final void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    c(this.JM);
  }
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.ajY.setQuery((CharSequence)paramView);
    }
  }
  
  public final Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = ""; (this.ajY.getVisibility() != 0) || (this.ajY.getWindowVisibility() != 0); paramCharSequence = paramCharSequence.toString()) {
      return null;
    }
    try
    {
      Object localObject1 = this.ajJ;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.as
 * JD-Core Version:    0.7.0.1
 */