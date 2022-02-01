package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;

public class RadioPreference
  extends Preference
{
  private AccessibilityManager jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager = (AccessibilityManager)getContext().getSystemService("accessibility");
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public RadioPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadioPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadioPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public void a(int paramInt)
  {
    a(getContext().getString(paramInt));
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    if (a()) {
      notifyChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    persistBoolean(paramBoolean);
    notifyDependencyChange(shouldDisableDependents());
    notifyChanged();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public CharSequence b()
  {
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  public void b(int paramInt)
  {
    b(getContext().getString(paramInt));
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    if (!a()) {
      notifyChanged();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean isPersistent()
  {
    return false;
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView = paramView.findViewById(2131301686);
    if ((paramView != null) && ((paramView instanceof Checkable)))
    {
      ((Checkable)paramView).setChecked(this.jdField_b_of_type_Boolean);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager.isEnabled()) && (paramView.isEnabled()))
      {
        this.jdField_a_of_type_Boolean = false;
        paramView.sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(1));
      }
    }
  }
  
  protected void onClick()
  {
    super.onClick();
    if (a()) {
      return;
    }
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = true;
      if (!callChangeListener(Boolean.valueOf(bool))) {
        break;
      }
      a(bool);
      return;
    }
  }
  
  protected Object onGetDefaultValue(TypedArray paramTypedArray, int paramInt)
  {
    return Boolean.valueOf(paramTypedArray.getBoolean(paramInt, false));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(RadioPreference.SavedState.class)))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (RadioPreference.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    a(paramParcelable.jdField_a_of_type_Boolean);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Object localObject = super.onSaveInstanceState();
    if (isPersistent()) {
      return localObject;
    }
    localObject = new RadioPreference.SavedState((Parcelable)localObject);
    ((RadioPreference.SavedState)localObject).jdField_a_of_type_Boolean = a();
    return localObject;
  }
  
  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (paramBoolean = getPersistedBoolean(this.jdField_b_of_type_Boolean);; paramBoolean = ((Boolean)paramObject).booleanValue())
    {
      a(paramBoolean);
      return;
    }
  }
  
  public boolean shouldDisableDependents()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.c) {
      bool1 = this.jdField_b_of_type_Boolean;
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.shouldDisableDependents()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (!this.jdField_b_of_type_Boolean) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.widget.RadioPreference
 * JD-Core Version:    0.7.0.1
 */