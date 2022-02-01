package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import androidx.fragment.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

class h
  implements LayoutInflater.Factory2
{
  final FragmentManager mFragmentManager;
  
  h(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, final AttributeSet paramAttributeSet)
  {
    Object localObject = null;
    AppMethodBeat.i(193809);
    if (FragmentContainerView.class.getName().equals(paramString))
    {
      paramView = new FragmentContainerView(paramContext, paramAttributeSet, this.mFragmentManager);
      AppMethodBeat.o(193809);
      return paramView;
    }
    if (!"fragment".equals(paramString))
    {
      AppMethodBeat.o(193809);
      return null;
    }
    paramString = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.Fragment);
    String str1 = paramString;
    if (paramString == null) {
      str1 = localTypedArray.getString(a.c.Fragment_android_name);
    }
    int k = localTypedArray.getResourceId(a.c.Fragment_android_id, -1);
    String str2 = localTypedArray.getString(a.c.Fragment_android_tag);
    localTypedArray.recycle();
    if ((str1 == null) || (!f.b(paramContext.getClassLoader(), str1)))
    {
      AppMethodBeat.o(193809);
      return null;
    }
    if (paramView != null) {}
    for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0)
    {
      paramView = new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      AppMethodBeat.o(193809);
      throw paramView;
    }
    paramString = (String)localObject;
    if (k != -1) {
      paramString = this.mFragmentManager.findFragmentById(k);
    }
    localObject = paramString;
    if (paramString == null)
    {
      localObject = paramString;
      if (str2 != null) {
        localObject = this.mFragmentManager.findFragmentByTag(str2);
      }
    }
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = (String)localObject;
      if (i != -1) {
        paramString = this.mFragmentManager.findFragmentById(i);
      }
    }
    int j;
    if (paramString == null)
    {
      paramString = this.mFragmentManager.getFragmentFactory().d(paramContext.getClassLoader(), str1);
      paramString.mFromLayout = true;
      if (k != 0)
      {
        j = k;
        paramString.mFragmentId = j;
        paramString.mContainerId = i;
        paramString.mTag = str2;
        paramString.mInLayout = true;
        paramString.mFragmentManager = this.mFragmentManager;
        paramString.mHost = this.mFragmentManager.getHost();
        paramString.onInflate(this.mFragmentManager.getHost().mContext, paramAttributeSet, paramString.mSavedFragmentState);
        paramAttributeSet = this.mFragmentManager.addFragment(paramString);
        if (!FragmentManager.isLoggingEnabled(2)) {
          break label762;
        }
        new StringBuilder("Fragment ").append(paramString).append(" has been inflated via the <fragment> tag: id=0x").append(Integer.toHexString(k));
        paramContext = paramString;
      }
    }
    for (;;)
    {
      paramContext.mContainer = ((ViewGroup)paramView);
      paramAttributeSet.Gq();
      paramAttributeSet.Gr();
      if (paramContext.mView == null)
      {
        paramView = new IllegalStateException("Fragment " + str1 + " did not create a view.");
        AppMethodBeat.o(193809);
        throw paramView;
        j = i;
        break;
        if (paramString.mInLayout)
        {
          paramView = new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
          AppMethodBeat.o(193809);
          throw paramView;
        }
        paramString.mInLayout = true;
        paramString.mFragmentManager = this.mFragmentManager;
        paramString.mHost = this.mFragmentManager.getHost();
        paramString.onInflate(this.mFragmentManager.getHost().mContext, paramAttributeSet, paramString.mSavedFragmentState);
        localObject = this.mFragmentManager.createOrGetFragmentStateManager(paramString);
        paramContext = paramString;
        paramAttributeSet = (AttributeSet)localObject;
        if (!FragmentManager.isLoggingEnabled(2)) {
          continue;
        }
        new StringBuilder("Retained Fragment ").append(paramString).append(" has been re-attached via the <fragment> tag: id=0x").append(Integer.toHexString(k));
        paramContext = paramString;
        paramAttributeSet = (AttributeSet)localObject;
        continue;
      }
      if (k != 0) {
        paramContext.mView.setId(k);
      }
      if (paramContext.mView.getTag() == null) {
        paramContext.mView.setTag(str2);
      }
      paramContext.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(193911);
          paramAnonymousView = paramAttributeSet.bDv;
          paramAttributeSet.Gq();
          x.a((ViewGroup)paramAnonymousView.mView.getParent(), h.this.mFragmentManager).GI();
          AppMethodBeat.o(193911);
        }
        
        public final void onViewDetachedFromWindow(View paramAnonymousView) {}
      });
      paramView = paramContext.mView;
      AppMethodBeat.o(193809);
      return paramView;
      label762:
      paramContext = paramString;
    }
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(193776);
    paramString = onCreateView(null, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(193776);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.h
 * JD-Core Version:    0.7.0.1
 */