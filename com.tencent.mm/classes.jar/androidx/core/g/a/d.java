package androidx.core.g.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import androidx.core.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d
{
  private static int buR = 0;
  public final AccessibilityNodeInfo buO;
  public int buP = -1;
  private int buQ = -1;
  
  private d(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.buO = paramAccessibilityNodeInfo;
  }
  
  public static d EI()
  {
    AppMethodBeat.i(196024);
    d locald = a(AccessibilityNodeInfo.obtain());
    AppMethodBeat.o(196024);
    return locald;
  }
  
  private boolean ES()
  {
    AppMethodBeat.i(196094);
    if (!az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty())
    {
      AppMethodBeat.o(196094);
      return true;
    }
    AppMethodBeat.o(196094);
    return false;
  }
  
  private List<a> EU()
  {
    AppMethodBeat.i(196117);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (List localList = this.buO.getActionList();; localList = null)
    {
      if (localList != null)
      {
        ArrayList localArrayList = new ArrayList();
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          localArrayList.add(new a(localList.get(i)));
          i += 1;
        }
        AppMethodBeat.o(196117);
        return localArrayList;
      }
      localList = Collections.emptyList();
      AppMethodBeat.o(196117);
      return localList;
    }
  }
  
  public static int a(ClickableSpan paramClickableSpan, SparseArray<WeakReference<ClickableSpan>> paramSparseArray)
  {
    AppMethodBeat.i(196075);
    if (paramSparseArray != null)
    {
      i = 0;
      while (i < paramSparseArray.size())
      {
        if (paramClickableSpan.equals((ClickableSpan)((WeakReference)paramSparseArray.valueAt(i)).get()))
        {
          i = paramSparseArray.keyAt(i);
          AppMethodBeat.o(196075);
          return i;
        }
        i += 1;
      }
    }
    int i = buR;
    buR = i + 1;
    AppMethodBeat.o(196075);
    return i;
  }
  
  public static d a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(196004);
    paramAccessibilityNodeInfo = new d(paramAccessibilityNodeInfo);
    AppMethodBeat.o(196004);
    return paramAccessibilityNodeInfo;
  }
  
  public static d a(d paramd)
  {
    AppMethodBeat.i(196033);
    paramd = a(AccessibilityNodeInfo.obtain(paramd.buO));
    AppMethodBeat.o(196033);
    return paramd;
  }
  
  public static d aK(View paramView)
  {
    AppMethodBeat.i(196013);
    paramView = a(AccessibilityNodeInfo.obtain(paramView));
    AppMethodBeat.o(196013);
    return paramView;
  }
  
  public static SparseArray<WeakReference<ClickableSpan>> aN(View paramView)
  {
    AppMethodBeat.i(196049);
    paramView = (SparseArray)paramView.getTag(a.c.tag_accessibility_clickable_spans);
    AppMethodBeat.o(196049);
    return paramView;
  }
  
  private static String ew(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ACTION_UNKNOWN";
    case 1: 
      return "ACTION_FOCUS";
    case 2: 
      return "ACTION_CLEAR_FOCUS";
    case 4: 
      return "ACTION_SELECT";
    case 8: 
      return "ACTION_CLEAR_SELECTION";
    case 16: 
      return "ACTION_CLICK";
    case 32: 
      return "ACTION_LONG_CLICK";
    case 64: 
      return "ACTION_ACCESSIBILITY_FOCUS";
    case 128: 
      return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    case 256: 
      return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    case 512: 
      return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    case 1024: 
      return "ACTION_NEXT_HTML_ELEMENT";
    case 2048: 
      return "ACTION_PREVIOUS_HTML_ELEMENT";
    case 4096: 
      return "ACTION_SCROLL_FORWARD";
    case 8192: 
      return "ACTION_SCROLL_BACKWARD";
    case 65536: 
      return "ACTION_CUT";
    case 16384: 
      return "ACTION_COPY";
    case 32768: 
      return "ACTION_PASTE";
    case 131072: 
      return "ACTION_SET_SELECTION";
    case 262144: 
      return "ACTION_EXPAND";
    case 524288: 
      return "ACTION_COLLAPSE";
    case 2097152: 
      return "ACTION_SET_TEXT";
    case 16908344: 
      return "ACTION_SCROLL_UP";
    case 16908345: 
      return "ACTION_SCROLL_LEFT";
    case 16908346: 
      return "ACTION_SCROLL_DOWN";
    case 16908347: 
      return "ACTION_SCROLL_RIGHT";
    case 16908359: 
      return "ACTION_PAGE_DOWN";
    case 16908358: 
      return "ACTION_PAGE_UP";
    case 16908360: 
      return "ACTION_PAGE_LEFT";
    case 16908361: 
      return "ACTION_PAGE_RIGHT";
    case 16908342: 
      return "ACTION_SHOW_ON_SCREEN";
    case 16908343: 
      return "ACTION_SCROLL_TO_POSITION";
    case 16908348: 
      return "ACTION_CONTEXT_CLICK";
    case 16908349: 
      return "ACTION_SET_PROGRESS";
    case 16908354: 
      return "ACTION_MOVE_WINDOW";
    case 16908356: 
      return "ACTION_SHOW_TOOLTIP";
    case 16908357: 
      return "ACTION_HIDE_TOOLTIP";
    case 16908362: 
      return "ACTION_PRESS_AND_HOLD";
    }
    return "ACTION_IME_ENTER";
  }
  
  private void t(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(196134);
    Bundle localBundle = getExtras();
    int j;
    if (localBundle != null)
    {
      j = localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
      if (!paramBoolean) {
        break label53;
      }
    }
    label53:
    for (int i = paramInt;; i = 0)
    {
      localBundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", j & (paramInt ^ 0xFFFFFFFF) | i);
      AppMethodBeat.o(196134);
      return;
    }
  }
  
  public static ClickableSpan[] w(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196059);
    if ((paramCharSequence instanceof Spanned))
    {
      paramCharSequence = (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
      AppMethodBeat.o(196059);
      return paramCharSequence;
    }
    AppMethodBeat.o(196059);
    return null;
  }
  
  public final void A(View paramView, int paramInt)
  {
    AppMethodBeat.i(196340);
    this.buP = paramInt;
    if (Build.VERSION.SDK_INT >= 16) {
      this.buO.setParent(paramView, paramInt);
    }
    AppMethodBeat.o(196340);
  }
  
  public final int EJ()
  {
    AppMethodBeat.i(196242);
    int i = this.buO.getActions();
    AppMethodBeat.o(196242);
    return i;
  }
  
  public final int EK()
  {
    AppMethodBeat.i(196314);
    if (Build.VERSION.SDK_INT >= 16)
    {
      int i = this.buO.getMovementGranularities();
      AppMethodBeat.o(196314);
      return i;
    }
    AppMethodBeat.o(196314);
    return 0;
  }
  
  public final boolean EL()
  {
    AppMethodBeat.i(196479);
    if (Build.VERSION.SDK_INT >= 16)
    {
      boolean bool = this.buO.isVisibleToUser();
      AppMethodBeat.o(196479);
      return bool;
    }
    AppMethodBeat.o(196479);
    return false;
  }
  
  public final boolean EM()
  {
    AppMethodBeat.i(196500);
    if (Build.VERSION.SDK_INT >= 16)
    {
      boolean bool = this.buO.isAccessibilityFocused();
      AppMethodBeat.o(196500);
      return bool;
    }
    AppMethodBeat.o(196500);
    return false;
  }
  
  public final boolean EN()
  {
    AppMethodBeat.i(196571);
    boolean bool = this.buO.isLongClickable();
    AppMethodBeat.o(196571);
    return bool;
  }
  
  public final boolean EO()
  {
    AppMethodBeat.i(196604);
    boolean bool = this.buO.isPassword();
    AppMethodBeat.o(196604);
    return bool;
  }
  
  public final boolean EP()
  {
    AppMethodBeat.i(196615);
    boolean bool = this.buO.isScrollable();
    AppMethodBeat.o(196615);
    return bool;
  }
  
  public final CharSequence EQ()
  {
    AppMethodBeat.i(196630);
    CharSequence localCharSequence = this.buO.getPackageName();
    AppMethodBeat.o(196630);
    return localCharSequence;
  }
  
  public final CharSequence ER()
  {
    AppMethodBeat.i(196650);
    CharSequence localCharSequence = this.buO.getClassName();
    AppMethodBeat.o(196650);
    return localCharSequence;
  }
  
  public final CharSequence ET()
  {
    AppMethodBeat.i(196692);
    CharSequence localCharSequence;
    if (androidx.core.c.a.DR())
    {
      localCharSequence = this.buO.getStateDescription();
      AppMethodBeat.o(196692);
      return localCharSequence;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localCharSequence = this.buO.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
      AppMethodBeat.o(196692);
      return localCharSequence;
    }
    AppMethodBeat.o(196692);
    return null;
  }
  
  public final void EV()
  {
    AppMethodBeat.i(196754);
    if (Build.VERSION.SDK_INT >= 19) {
      this.buO.setContentInvalid(true);
    }
    AppMethodBeat.o(196754);
  }
  
  public final void EW()
  {
    AppMethodBeat.i(196781);
    if (Build.VERSION.SDK_INT >= 19) {
      this.buO.setCanOpenPopup(true);
    }
    AppMethodBeat.o(196781);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(196281);
    if (Build.VERSION.SDK_INT >= 21) {
      this.buO.addAction((AccessibilityNodeInfo.AccessibilityAction)parama.bvF);
    }
    AppMethodBeat.o(196281);
  }
  
  public final void aB(Object paramObject)
  {
    AppMethodBeat.i(196731);
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.buO;
      if (paramObject != null) {
        break label37;
      }
    }
    label37:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionInfo)((d.b)paramObject).bvI)
    {
      localAccessibilityNodeInfo.setCollectionInfo(paramObject);
      AppMethodBeat.o(196731);
      return;
    }
  }
  
  public final void aC(Object paramObject)
  {
    AppMethodBeat.i(196740);
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.buO;
      if (paramObject != null) {
        break label37;
      }
    }
    label37:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((d.c)paramObject).bvI)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
      AppMethodBeat.o(196740);
      return;
    }
  }
  
  public final void aE(boolean paramBoolean)
  {
    AppMethodBeat.i(196468);
    this.buO.setFocused(paramBoolean);
    AppMethodBeat.o(196468);
  }
  
  public final void aF(boolean paramBoolean)
  {
    AppMethodBeat.i(196491);
    if (Build.VERSION.SDK_INT >= 16) {
      this.buO.setVisibleToUser(paramBoolean);
    }
    AppMethodBeat.o(196491);
  }
  
  public final void aG(boolean paramBoolean)
  {
    AppMethodBeat.i(196512);
    if (Build.VERSION.SDK_INT >= 16) {
      this.buO.setAccessibilityFocused(paramBoolean);
    }
    AppMethodBeat.o(196512);
  }
  
  public final void aH(boolean paramBoolean)
  {
    AppMethodBeat.i(196625);
    this.buO.setScrollable(paramBoolean);
    AppMethodBeat.o(196625);
  }
  
  public final void aI(boolean paramBoolean)
  {
    AppMethodBeat.i(196799);
    if (Build.VERSION.SDK_INT >= 19) {
      this.buO.setDismissable(paramBoolean);
    }
    AppMethodBeat.o(196799);
  }
  
  public final void aJ(boolean paramBoolean)
  {
    AppMethodBeat.i(196819);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.buO.setScreenReaderFocusable(paramBoolean);
      AppMethodBeat.o(196819);
      return;
    }
    t(1, paramBoolean);
    AppMethodBeat.o(196819);
  }
  
  public final void aK(boolean paramBoolean)
  {
    AppMethodBeat.i(196829);
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.buO.setShowingHintText(paramBoolean);
      AppMethodBeat.o(196829);
      return;
    }
    t(4, paramBoolean);
    AppMethodBeat.o(196829);
  }
  
  public final void aL(View paramView)
  {
    AppMethodBeat.i(196181);
    this.buQ = -1;
    this.buO.setSource(paramView);
    AppMethodBeat.o(196181);
  }
  
  public final void aL(boolean paramBoolean)
  {
    AppMethodBeat.i(196835);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.buO.setHeading(paramBoolean);
      AppMethodBeat.o(196835);
      return;
    }
    t(2, paramBoolean);
    AppMethodBeat.o(196835);
  }
  
  public final void aM(View paramView)
  {
    AppMethodBeat.i(196217);
    this.buO.addChild(paramView);
    AppMethodBeat.o(196217);
  }
  
  public final List<Integer> az(String paramString)
  {
    AppMethodBeat.i(196272);
    if (Build.VERSION.SDK_INT < 19)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(196272);
      return paramString;
    }
    ArrayList localArrayList2 = this.buO.getExtras().getIntegerArrayList(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.buO.getExtras().putIntegerArrayList(paramString, localArrayList1);
    }
    AppMethodBeat.o(196272);
    return localArrayList1;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(196292);
    if (Build.VERSION.SDK_INT >= 21)
    {
      boolean bool = this.buO.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.bvF);
      AppMethodBeat.o(196292);
      return bool;
    }
    AppMethodBeat.o(196292);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196854);
    if (this == paramObject)
    {
      AppMethodBeat.o(196854);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(196854);
      return false;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(196854);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.buO == null)
    {
      if (paramObject.buO != null)
      {
        AppMethodBeat.o(196854);
        return false;
      }
    }
    else if (!this.buO.equals(paramObject.buO))
    {
      AppMethodBeat.o(196854);
      return false;
    }
    if (this.buQ != paramObject.buQ)
    {
      AppMethodBeat.o(196854);
      return false;
    }
    if (this.buP != paramObject.buP)
    {
      AppMethodBeat.o(196854);
      return false;
    }
    AppMethodBeat.o(196854);
    return true;
  }
  
  public final void eu(int paramInt)
  {
    AppMethodBeat.i(196258);
    this.buO.addAction(paramInt);
    AppMethodBeat.o(196258);
  }
  
  public final void ev(int paramInt)
  {
    AppMethodBeat.i(196304);
    if (Build.VERSION.SDK_INT >= 16) {
      this.buO.setMovementGranularities(paramInt);
    }
    AppMethodBeat.o(196304);
  }
  
  public final int getChildCount()
  {
    AppMethodBeat.i(196206);
    int i = this.buO.getChildCount();
    AppMethodBeat.o(196206);
    return i;
  }
  
  public final CharSequence getContentDescription()
  {
    AppMethodBeat.i(196681);
    CharSequence localCharSequence = this.buO.getContentDescription();
    AppMethodBeat.o(196681);
    return localCharSequence;
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(196789);
    if (Build.VERSION.SDK_INT >= 19)
    {
      localBundle = this.buO.getExtras();
      AppMethodBeat.o(196789);
      return localBundle;
    }
    Bundle localBundle = new Bundle();
    AppMethodBeat.o(196789);
    return localBundle;
  }
  
  public final CharSequence getText()
  {
    AppMethodBeat.i(196666);
    if (ES())
    {
      localObject = az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      List localList1 = az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      List localList2 = az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      List localList3 = az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
      SpannableString localSpannableString = new SpannableString(TextUtils.substring(this.buO.getText(), 0, this.buO.getText().length()));
      int i = 0;
      while (i < ((List)localObject).size())
      {
        localSpannableString.setSpan(new a(((Integer)localList3.get(i)).intValue(), this, getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)((List)localObject).get(i)).intValue(), ((Integer)localList1.get(i)).intValue(), ((Integer)localList2.get(i)).intValue());
        i += 1;
      }
      AppMethodBeat.o(196666);
      return localSpannableString;
    }
    Object localObject = this.buO.getText();
    AppMethodBeat.o(196666);
    return localObject;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(196846);
    if (this.buO == null)
    {
      AppMethodBeat.o(196846);
      return 0;
    }
    int i = this.buO.hashCode();
    AppMethodBeat.o(196846);
    return i;
  }
  
  public final boolean isChecked()
  {
    AppMethodBeat.i(196424);
    boolean bool = this.buO.isChecked();
    AppMethodBeat.o(196424);
    return bool;
  }
  
  public final boolean isClickable()
  {
    AppMethodBeat.i(196547);
    boolean bool = this.buO.isClickable();
    AppMethodBeat.o(196547);
    return bool;
  }
  
  public final boolean isEnabled()
  {
    AppMethodBeat.i(196588);
    boolean bool = this.buO.isEnabled();
    AppMethodBeat.o(196588);
    return bool;
  }
  
  public final boolean isFocusable()
  {
    AppMethodBeat.i(369499);
    boolean bool = this.buO.isFocusable();
    AppMethodBeat.o(369499);
    return bool;
  }
  
  public final boolean isFocused()
  {
    AppMethodBeat.i(369500);
    boolean bool = this.buO.isFocused();
    AppMethodBeat.o(369500);
    return bool;
  }
  
  public final boolean isSelected()
  {
    AppMethodBeat.i(196521);
    boolean bool = this.buO.isSelected();
    AppMethodBeat.o(196521);
    return bool;
  }
  
  @Deprecated
  public final void j(Rect paramRect)
  {
    AppMethodBeat.i(196352);
    this.buO.getBoundsInParent(paramRect);
    AppMethodBeat.o(196352);
  }
  
  @Deprecated
  public final void k(Rect paramRect)
  {
    AppMethodBeat.i(196368);
    this.buO.setBoundsInParent(paramRect);
    AppMethodBeat.o(196368);
  }
  
  public final void l(Rect paramRect)
  {
    AppMethodBeat.i(196382);
    this.buO.getBoundsInScreen(paramRect);
    AppMethodBeat.o(196382);
  }
  
  public final void m(Rect paramRect)
  {
    AppMethodBeat.i(196395);
    this.buO.setBoundsInScreen(paramRect);
    AppMethodBeat.o(196395);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(369501);
    this.buO.recycle();
    AppMethodBeat.o(369501);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(196412);
    this.buO.setCheckable(paramBoolean);
    AppMethodBeat.o(196412);
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(196431);
    this.buO.setChecked(paramBoolean);
    AppMethodBeat.o(196431);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(196561);
    this.buO.setClickable(paramBoolean);
    AppMethodBeat.o(196561);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196702);
    this.buO.setContentDescription(paramCharSequence);
    AppMethodBeat.o(196702);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(196599);
    this.buO.setEnabled(paramBoolean);
    AppMethodBeat.o(196599);
  }
  
  public final void setError(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196769);
    if (Build.VERSION.SDK_INT >= 21) {
      this.buO.setError(paramCharSequence);
    }
    AppMethodBeat.o(196769);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(196444);
    this.buO.setFocusable(paramBoolean);
    AppMethodBeat.o(196444);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(196580);
    this.buO.setLongClickable(paramBoolean);
    AppMethodBeat.o(196580);
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(196327);
    this.buP = -1;
    this.buO.setParent(paramView);
    AppMethodBeat.o(196327);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(196534);
    this.buO.setSelected(paramBoolean);
    AppMethodBeat.o(196534);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196674);
    this.buO.setText(paramCharSequence);
    AppMethodBeat.o(196674);
  }
  
  public String toString()
  {
    AppMethodBeat.i(196869);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject1 = new Rect();
    j((Rect)localObject1);
    localStringBuilder.append("; boundsInParent: ".concat(String.valueOf(localObject1)));
    l((Rect)localObject1);
    localStringBuilder.append("; boundsInScreen: ".concat(String.valueOf(localObject1)));
    localStringBuilder.append("; packageName: ").append(this.buO.getPackageName());
    localStringBuilder.append("; className: ").append(this.buO.getClassName());
    localStringBuilder.append("; text: ").append(getText());
    localStringBuilder.append("; contentDescription: ").append(this.buO.getContentDescription());
    Object localObject2 = localStringBuilder.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject1 = this.buO.getViewIdResourceName();
      ((StringBuilder)localObject2).append((String)localObject1);
      localStringBuilder.append("; checkable: ").append(this.buO.isCheckable());
      localStringBuilder.append("; checked: ").append(this.buO.isChecked());
      localStringBuilder.append("; focusable: ").append(this.buO.isFocusable());
      localStringBuilder.append("; focused: ").append(this.buO.isFocused());
      localStringBuilder.append("; selected: ").append(this.buO.isSelected());
      localStringBuilder.append("; clickable: ").append(this.buO.isClickable());
      localStringBuilder.append("; longClickable: ").append(this.buO.isLongClickable());
      localStringBuilder.append("; enabled: ").append(this.buO.isEnabled());
      localStringBuilder.append("; password: ").append(this.buO.isPassword());
      localStringBuilder.append("; scrollable: " + this.buO.isScrollable());
      localStringBuilder.append("; [");
      if (Build.VERSION.SDK_INT < 21) {
        break label520;
      }
      localObject2 = EU();
      i = 0;
      label413:
      if (i >= ((List)localObject2).size()) {
        break label575;
      }
      a locala = (a)((List)localObject2).get(i);
      localObject1 = ew(locala.getId());
      if ((!((String)localObject1).equals("ACTION_UNKNOWN")) || (locala.EX() == null)) {
        break label600;
      }
      localObject1 = locala.EX().toString();
    }
    label520:
    label575:
    label600:
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      if (i != ((List)localObject2).size() - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
      break label413;
      localObject1 = null;
      break;
      i = this.buO.getActions();
      while (i != 0)
      {
        int k = 1 << Integer.numberOfTrailingZeros(i);
        int j = i & (k ^ 0xFFFFFFFF);
        localStringBuilder.append(ew(k));
        i = j;
        if (j != 0)
        {
          localStringBuilder.append(", ");
          i = j;
        }
      }
      localStringBuilder.append("]");
      localObject1 = localStringBuilder.toString();
      AppMethodBeat.o(196869);
      return localObject1;
    }
  }
  
  public final void u(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196639);
    this.buO.setPackageName(paramCharSequence);
    AppMethodBeat.o(196639);
  }
  
  public final void v(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196659);
    this.buO.setClassName(paramCharSequence);
    AppMethodBeat.o(196659);
  }
  
  public final void x(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196713);
    if (androidx.core.c.a.DR())
    {
      this.buO.setStateDescription(paramCharSequence);
      AppMethodBeat.o(196713);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      this.buO.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", paramCharSequence);
    }
    AppMethodBeat.o(196713);
  }
  
  public final void y(View paramView, int paramInt)
  {
    AppMethodBeat.i(196195);
    this.buQ = paramInt;
    if (Build.VERSION.SDK_INT >= 16) {
      this.buO.setSource(paramView, paramInt);
    }
    AppMethodBeat.o(196195);
  }
  
  public final void y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196761);
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.buO.setHintText(paramCharSequence);
      AppMethodBeat.o(196761);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      this.buO.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", paramCharSequence);
    }
    AppMethodBeat.o(196761);
  }
  
  public final void z(View paramView, int paramInt)
  {
    AppMethodBeat.i(196231);
    if (Build.VERSION.SDK_INT >= 16) {
      this.buO.addChild(paramView, paramInt);
    }
    AppMethodBeat.o(196231);
  }
  
  public final void z(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196809);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.buO.setPaneTitle(paramCharSequence);
      AppMethodBeat.o(196809);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      this.buO.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", paramCharSequence);
    }
    AppMethodBeat.o(196809);
  }
  
  public static final class a
  {
    public static final a buS;
    public static final a buT;
    public static final a buU;
    public static final a buV;
    public static final a buW;
    public static final a buX;
    public static final a buY;
    public static final a buZ;
    public static final a bvA;
    public static final a bvB;
    public static final a bvC;
    public static final a bvD;
    public static final a bvE;
    public static final a bva;
    public static final a bvb;
    public static final a bvc;
    public static final a bvd;
    public static final a bve;
    public static final a bvf;
    public static final a bvg;
    public static final a bvh;
    public static final a bvi;
    public static final a bvj;
    public static final a bvk;
    public static final a bvl;
    public static final a bvm;
    public static final a bvn;
    public static final a bvo;
    public static final a bvp;
    public static final a bvq;
    public static final a bvr;
    public static final a bvs;
    public static final a bvt;
    public static final a bvu;
    public static final a bvv;
    public static final a bvw;
    public static final a bvx;
    public static final a bvy;
    public static final a bvz;
    final Object bvF;
    private final Class<? extends g.a> bvG;
    protected final g bvH;
    private final int mId;
    
    static
    {
      AppMethodBeat.i(196014);
      buS = new a(1, null);
      buT = new a(2, null);
      buU = new a(4, null);
      buV = new a(8, null);
      buW = new a(16, null);
      buX = new a(32, null);
      buY = new a(64, null);
      buZ = new a(128, null);
      bva = new a(256, g.b.class);
      bvb = new a(512, g.b.class);
      bvc = new a(1024, g.c.class);
      bvd = new a(2048, g.c.class);
      bve = new a(4096, null);
      bvf = new a(8192, null);
      bvg = new a(16384, null);
      bvh = new a(32768, null);
      bvi = new a(65536, null);
      bvj = new a(131072, g.g.class);
      bvk = new a(262144, null);
      bvl = new a(524288, null);
      bvm = new a(1048576, null);
      bvn = new a(2097152, g.h.class);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        bvo = new a(localAccessibilityAction, 16908342, null, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label775;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        label341:
        bvp = new a(localAccessibilityAction, 16908343, null, g.e.class);
        if (Build.VERSION.SDK_INT < 23) {
          break label780;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        label369:
        bvq = new a(localAccessibilityAction, 16908344, null, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label785;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        label396:
        bvr = new a(localAccessibilityAction, 16908345, null, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label790;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        label423:
        bvs = new a(localAccessibilityAction, 16908346, null, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label795;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        label450:
        bvt = new a(localAccessibilityAction, 16908347, null, null);
        if (Build.VERSION.SDK_INT < 29) {
          break label800;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
        label477:
        bvu = new a(localAccessibilityAction, 16908358, null, null);
        if (Build.VERSION.SDK_INT < 29) {
          break label805;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
        label504:
        bvv = new a(localAccessibilityAction, 16908359, null, null);
        if (Build.VERSION.SDK_INT < 29) {
          break label810;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
        label531:
        bvw = new a(localAccessibilityAction, 16908360, null, null);
        if (Build.VERSION.SDK_INT < 29) {
          break label815;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
        label558:
        bvx = new a(localAccessibilityAction, 16908361, null, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label820;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        label585:
        bvy = new a(localAccessibilityAction, 16908348, null, null);
        if (Build.VERSION.SDK_INT < 24) {
          break label825;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        label612:
        bvz = new a(localAccessibilityAction, 16908349, null, g.f.class);
        if (Build.VERSION.SDK_INT < 26) {
          break label830;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        label640:
        bvA = new a(localAccessibilityAction, 16908354, null, g.d.class);
        if (Build.VERSION.SDK_INT < 28) {
          break label835;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
        label668:
        bvB = new a(localAccessibilityAction, 16908356, null, null);
        if (Build.VERSION.SDK_INT < 28) {
          break label840;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        label695:
        bvC = new a(localAccessibilityAction, 16908357, null, null);
        if (Build.VERSION.SDK_INT < 30) {
          break label845;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
        label722:
        bvD = new a(localAccessibilityAction, 16908362, null, null);
        if (Build.VERSION.SDK_INT < 30) {
          break label850;
        }
      }
      label775:
      label780:
      label785:
      label790:
      label795:
      label800:
      label805:
      label810:
      label815:
      label820:
      label825:
      label830:
      label835:
      label840:
      label845:
      label850:
      for (AccessibilityNodeInfo.AccessibilityAction localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;; localAccessibilityAction = null)
      {
        bvE = new a(localAccessibilityAction, 16908372, null, null);
        AppMethodBeat.o(196014);
        return;
        localAccessibilityAction = null;
        break;
        localAccessibilityAction = null;
        break label341;
        localAccessibilityAction = null;
        break label369;
        localAccessibilityAction = null;
        break label396;
        localAccessibilityAction = null;
        break label423;
        localAccessibilityAction = null;
        break label450;
        localAccessibilityAction = null;
        break label477;
        localAccessibilityAction = null;
        break label504;
        localAccessibilityAction = null;
        break label531;
        localAccessibilityAction = null;
        break label558;
        localAccessibilityAction = null;
        break label585;
        localAccessibilityAction = null;
        break label612;
        localAccessibilityAction = null;
        break label640;
        localAccessibilityAction = null;
        break label668;
        localAccessibilityAction = null;
        break label695;
        localAccessibilityAction = null;
        break label722;
      }
    }
    
    public a(int paramInt, CharSequence paramCharSequence)
    {
      this(null, paramInt, paramCharSequence, null);
    }
    
    private a(int paramInt, Class<? extends g.a> paramClass)
    {
      this(null, paramInt, null, paramClass);
    }
    
    a(Object paramObject)
    {
      this(paramObject, 0, null, null);
    }
    
    private a(Object paramObject, int paramInt, CharSequence paramCharSequence, Class<? extends g.a> paramClass)
    {
      AppMethodBeat.i(196000);
      this.mId = paramInt;
      this.bvH = null;
      if ((Build.VERSION.SDK_INT >= 21) && (paramObject == null)) {}
      for (this.bvF = new AccessibilityNodeInfo.AccessibilityAction(paramInt, paramCharSequence);; this.bvF = paramObject)
      {
        this.bvG = paramClass;
        AppMethodBeat.o(196000);
        return;
      }
    }
    
    public final CharSequence EX()
    {
      AppMethodBeat.i(196025);
      if (Build.VERSION.SDK_INT >= 21)
      {
        CharSequence localCharSequence = ((AccessibilityNodeInfo.AccessibilityAction)this.bvF).getLabel();
        AppMethodBeat.o(196025);
        return localCharSequence;
      }
      AppMethodBeat.o(196025);
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196050);
      if (paramObject == null)
      {
        AppMethodBeat.o(196050);
        return false;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(196050);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.bvF == null)
      {
        if (paramObject.bvF != null)
        {
          AppMethodBeat.o(196050);
          return false;
        }
      }
      else if (!this.bvF.equals(paramObject.bvF))
      {
        AppMethodBeat.o(196050);
        return false;
      }
      AppMethodBeat.o(196050);
      return true;
    }
    
    public final int getId()
    {
      AppMethodBeat.i(196020);
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i = ((AccessibilityNodeInfo.AccessibilityAction)this.bvF).getId();
        AppMethodBeat.o(196020);
        return i;
      }
      AppMethodBeat.o(196020);
      return 0;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(196041);
      if (this.bvF != null)
      {
        int i = this.bvF.hashCode();
        AppMethodBeat.o(196041);
        return i;
      }
      AppMethodBeat.o(196041);
      return 0;
    }
    
    public final boolean l(Bundle paramBundle)
    {
      AppMethodBeat.i(196032);
      if (this.bvH != null)
      {
        if (this.bvG != null) {}
        try
        {
          ((g.a)this.bvG.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).mBundle = paramBundle;
          boolean bool = this.bvH.Fa();
          AppMethodBeat.o(196032);
          return bool;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            if (this.bvG != null) {
              this.bvG.getName();
            }
          }
        }
      }
      AppMethodBeat.o(196032);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.a.d
 * JD-Core Version:    0.7.0.1
 */