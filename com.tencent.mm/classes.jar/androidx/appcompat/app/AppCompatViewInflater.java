package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a.j;
import androidx.appcompat.view.d;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.Map;

public class AppCompatViewInflater
{
  private static final String LOG_TAG = "AppCompatViewInflater";
  private static final String[] sClassPrefixList;
  private static final Map<String, Constructor<? extends View>> sConstructorMap;
  private static final Class<?>[] sConstructorSignature;
  private static final int[] sOnClickAttrs;
  private final Object[] mConstructorArgs;
  
  static
  {
    AppMethodBeat.i(200431);
    sConstructorSignature = new Class[] { Context.class, AttributeSet.class };
    sOnClickAttrs = new int[] { 16843375 };
    sClassPrefixList = new String[] { "android.widget.", "android.view.", "android.webkit." };
    sConstructorMap = new a();
    AppMethodBeat.o(200431);
  }
  
  public AppCompatViewInflater()
  {
    AppMethodBeat.i(200373);
    this.mConstructorArgs = new Object[2];
    AppMethodBeat.o(200373);
  }
  
  private void checkOnClickListener(View paramView, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200402);
    Object localObject = paramView.getContext();
    if ((!(localObject instanceof ContextWrapper)) || ((Build.VERSION.SDK_INT >= 15) && (!androidx.core.g.z.az(paramView))))
    {
      AppMethodBeat.o(200402);
      return;
    }
    paramAttributeSet = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, sOnClickAttrs);
    localObject = paramAttributeSet.getString(0);
    if (localObject != null) {
      paramView.setOnClickListener(new AppCompatViewInflater.a(paramView, (String)localObject));
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(200402);
  }
  
  private View createViewByPrefix(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(200416);
    Constructor localConstructor = (Constructor)sConstructorMap.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null) {}
      for (paramContext = paramString2 + paramString1;; paramContext = paramString1)
      {
        localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(sConstructorSignature);
        sConstructorMap.put(paramString1, localObject);
        ((Constructor)localObject).setAccessible(true);
        paramContext = (View)((Constructor)localObject).newInstance(this.mConstructorArgs);
        AppMethodBeat.o(200416);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(200416);
    }
  }
  
  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200390);
    String str = paramString;
    if (paramString.equals("view")) {
      str = paramAttributeSet.getAttributeValue(null, "class");
    }
    try
    {
      this.mConstructorArgs[0] = paramContext;
      this.mConstructorArgs[1] = paramAttributeSet;
      if (-1 == str.indexOf('.'))
      {
        int i = 0;
        while (i < sClassPrefixList.length)
        {
          paramString = createViewByPrefix(paramContext, str, sClassPrefixList[i]);
          if (paramString != null) {
            return paramString;
          }
          i += 1;
        }
        return null;
      }
      paramContext = createViewByPrefix(paramContext, str, null);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return null;
    }
    finally
    {
      this.mConstructorArgs[0] = null;
      this.mConstructorArgs[1] = null;
      AppMethodBeat.o(200390);
    }
  }
  
  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(200425);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.View, 0, 0);
    if (paramBoolean1) {}
    for (int i = paramAttributeSet.getResourceId(a.j.View_android_theme, 0);; i = 0)
    {
      if ((paramBoolean2) && (i == 0)) {
        i = paramAttributeSet.getResourceId(a.j.View_theme, 0);
      }
      for (;;)
      {
        paramAttributeSet.recycle();
        paramAttributeSet = paramContext;
        if (i != 0) {
          if ((paramContext instanceof d))
          {
            paramAttributeSet = paramContext;
            if (((d)paramContext).kI == i) {}
          }
          else
          {
            paramAttributeSet = new d(paramContext, i);
          }
        }
        AppMethodBeat.o(200425);
        return paramAttributeSet;
      }
    }
  }
  
  private void verifyNotNull(View paramView, String paramString)
  {
    AppMethodBeat.i(200381);
    if (paramView == null)
    {
      paramView = new IllegalStateException(getClass().getName() + " asked to inflate view for <" + paramString + ">, but returned null");
      AppMethodBeat.o(200381);
      throw paramView;
    }
    AppMethodBeat.o(200381);
  }
  
  protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200520);
    paramContext = new AppCompatAutoCompleteTextView(paramContext, paramAttributeSet);
    AppMethodBeat.o(200520);
    return paramContext;
  }
  
  protected AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200470);
    paramContext = new AppCompatButton(paramContext, paramAttributeSet);
    AppMethodBeat.o(200470);
    return paramContext;
  }
  
  protected AppCompatCheckBox createCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200500);
    paramContext = new AppCompatCheckBox(paramContext, paramAttributeSet);
    AppMethodBeat.o(200500);
    return paramContext;
  }
  
  protected AppCompatCheckedTextView createCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200512);
    paramContext = new AppCompatCheckedTextView(paramContext, paramAttributeSet);
    AppMethodBeat.o(200512);
    return paramContext;
  }
  
  protected AppCompatEditText createEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200478);
    paramContext = new AppCompatEditText(paramContext, paramAttributeSet);
    AppMethodBeat.o(200478);
    return paramContext;
  }
  
  protected AppCompatImageButton createImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200494);
    paramContext = new AppCompatImageButton(paramContext, paramAttributeSet);
    AppMethodBeat.o(200494);
    return paramContext;
  }
  
  protected AppCompatImageView createImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200463);
    paramContext = new AppCompatImageView(paramContext, paramAttributeSet);
    AppMethodBeat.o(200463);
    return paramContext;
  }
  
  protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200535);
    paramContext = new AppCompatMultiAutoCompleteTextView(paramContext, paramAttributeSet);
    AppMethodBeat.o(200535);
    return paramContext;
  }
  
  protected AppCompatRadioButton createRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200507);
    paramContext = new AppCompatRadioButton(paramContext, paramAttributeSet);
    AppMethodBeat.o(200507);
    return paramContext;
  }
  
  protected AppCompatRatingBar createRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200543);
    paramContext = new AppCompatRatingBar(paramContext, paramAttributeSet);
    AppMethodBeat.o(200543);
    return paramContext;
  }
  
  protected AppCompatSeekBar createSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200549);
    paramContext = new AppCompatSeekBar(paramContext, paramAttributeSet);
    AppMethodBeat.o(200549);
    return paramContext;
  }
  
  protected AppCompatSpinner createSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200488);
    paramContext = new AppCompatSpinner(paramContext, paramAttributeSet);
    AppMethodBeat.o(200488);
    return paramContext;
  }
  
  protected AppCompatTextView createTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(200455);
    paramContext = new AppCompatTextView(paramContext, paramAttributeSet);
    AppMethodBeat.o(200455);
    return paramContext;
  }
  
  protected View createView(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  final View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(200447);
    if ((paramBoolean1) && (paramView != null)) {}
    for (Object localObject = paramView.getContext();; localObject = paramContext)
    {
      if (!paramBoolean2)
      {
        paramView = (View)localObject;
        if (!paramBoolean3) {}
      }
      else
      {
        paramView = themifyContext((Context)localObject, paramAttributeSet, paramBoolean2, paramBoolean3);
      }
      localObject = paramView;
      if (paramBoolean4) {
        localObject = androidx.appcompat.widget.z.L(paramView);
      }
      int i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          paramView = createView((Context)localObject, paramString, paramAttributeSet);
          label258:
          if ((paramView == null) && (paramContext != localObject)) {
            paramView = createViewFromTag((Context)localObject, paramString, paramAttributeSet);
          }
          break;
        }
        break;
      }
      for (;;)
      {
        if (paramView != null) {
          checkOnClickListener(paramView, paramAttributeSet);
        }
        AppMethodBeat.o(200447);
        return paramView;
        if (!paramString.equals("TextView")) {
          break;
        }
        i = 0;
        break;
        if (!paramString.equals("ImageView")) {
          break;
        }
        i = 1;
        break;
        if (!paramString.equals("Button")) {
          break;
        }
        i = 2;
        break;
        if (!paramString.equals("EditText")) {
          break;
        }
        i = 3;
        break;
        if (!paramString.equals("Spinner")) {
          break;
        }
        i = 4;
        break;
        if (!paramString.equals("ImageButton")) {
          break;
        }
        i = 5;
        break;
        if (!paramString.equals("CheckBox")) {
          break;
        }
        i = 6;
        break;
        if (!paramString.equals("RadioButton")) {
          break;
        }
        i = 7;
        break;
        if (!paramString.equals("CheckedTextView")) {
          break;
        }
        i = 8;
        break;
        if (!paramString.equals("AutoCompleteTextView")) {
          break;
        }
        i = 9;
        break;
        if (!paramString.equals("MultiAutoCompleteTextView")) {
          break;
        }
        i = 10;
        break;
        if (!paramString.equals("RatingBar")) {
          break;
        }
        i = 11;
        break;
        if (!paramString.equals("SeekBar")) {
          break;
        }
        i = 12;
        break;
        paramView = createTextView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createImageView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createButton((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createEditText((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createSpinner((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createImageButton((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createCheckBox((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createRadioButton((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createCheckedTextView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createAutoCompleteTextView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createMultiAutoCompleteTextView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createRatingBar((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
        paramView = createSeekBar((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label258;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatViewInflater
 * JD-Core Version:    0.7.0.1
 */