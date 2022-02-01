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
  private static int Oy = 0;
  public final AccessibilityNodeInfo Ov;
  public int Ow = -1;
  public int Ox = -1;
  
  private d(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.Ov = paramAccessibilityNodeInfo;
  }
  
  public static int a(ClickableSpan paramClickableSpan, SparseArray<WeakReference<ClickableSpan>> paramSparseArray)
  {
    AppMethodBeat.i(252143);
    if (paramSparseArray != null)
    {
      i = 0;
      while (i < paramSparseArray.size())
      {
        if (paramClickableSpan.equals((ClickableSpan)((WeakReference)paramSparseArray.valueAt(i)).get()))
        {
          i = paramSparseArray.keyAt(i);
          AppMethodBeat.o(252143);
          return i;
        }
        i += 1;
      }
    }
    int i = Oy;
    Oy = i + 1;
    AppMethodBeat.o(252143);
    return i;
  }
  
  public static d a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(252083);
    paramAccessibilityNodeInfo = new d(paramAccessibilityNodeInfo);
    AppMethodBeat.o(252083);
    return paramAccessibilityNodeInfo;
  }
  
  public static d a(d paramd)
  {
    AppMethodBeat.i(252091);
    paramd = a(AccessibilityNodeInfo.obtain(paramd.Ov));
    AppMethodBeat.o(252091);
    return paramd;
  }
  
  public static d aw(View paramView)
  {
    AppMethodBeat.i(252085);
    paramView = a(AccessibilityNodeInfo.obtain(paramView));
    AppMethodBeat.o(252085);
    return paramView;
  }
  
  public static SparseArray<WeakReference<ClickableSpan>> az(View paramView)
  {
    AppMethodBeat.i(252141);
    paramView = (SparseArray)paramView.getTag(a.c.tag_accessibility_clickable_spans);
    AppMethodBeat.o(252141);
    return paramView;
  }
  
  private static String bB(int paramInt)
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
    }
    return "ACTION_HIDE_TOOLTIP";
  }
  
  public static d hr()
  {
    AppMethodBeat.i(252088);
    d locald = a(AccessibilityNodeInfo.obtain());
    AppMethodBeat.o(252088);
    return locald;
  }
  
  private List<a> hu()
  {
    AppMethodBeat.i(252149);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (List localList = this.Ov.getActionList();; localList = null)
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
        AppMethodBeat.o(252149);
        return localArrayList;
      }
      localList = Collections.emptyList();
      AppMethodBeat.o(252149);
      return localList;
    }
  }
  
  public static ClickableSpan[] u(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252142);
    if ((paramCharSequence instanceof Spanned))
    {
      paramCharSequence = (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
      AppMethodBeat.o(252142);
      return paramCharSequence;
    }
    AppMethodBeat.o(252142);
    return null;
  }
  
  public final void D(Object paramObject)
  {
    AppMethodBeat.i(252146);
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.Ov;
      if (paramObject != null) {
        break label35;
      }
    }
    label35:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((c)paramObject).Pq)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
      AppMethodBeat.o(252146);
      return;
    }
  }
  
  public final List<Integer> F(String paramString)
  {
    AppMethodBeat.i(252098);
    if (Build.VERSION.SDK_INT < 19)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(252098);
      return paramString;
    }
    ArrayList localArrayList2 = this.Ov.getExtras().getIntegerArrayList(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.Ov.getExtras().putIntegerArrayList(paramString, localArrayList1);
    }
    AppMethodBeat.o(252098);
    return localArrayList1;
  }
  
  public final void Y(boolean paramBoolean)
  {
    AppMethodBeat.i(252114);
    this.Ov.setFocused(paramBoolean);
    AppMethodBeat.o(252114);
  }
  
  public final void Z(boolean paramBoolean)
  {
    AppMethodBeat.i(252118);
    if (Build.VERSION.SDK_INT >= 16) {
      this.Ov.setVisibleToUser(paramBoolean);
    }
    AppMethodBeat.o(252118);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(252099);
    if (Build.VERSION.SDK_INT >= 21) {
      this.Ov.addAction((AccessibilityNodeInfo.AccessibilityAction)parama.Pn);
    }
    AppMethodBeat.o(252099);
  }
  
  public final void aa(boolean paramBoolean)
  {
    AppMethodBeat.i(252121);
    if (Build.VERSION.SDK_INT >= 16) {
      this.Ov.setAccessibilityFocused(paramBoolean);
    }
    AppMethodBeat.o(252121);
  }
  
  public final void ab(boolean paramBoolean)
  {
    AppMethodBeat.i(252130);
    this.Ov.setScrollable(paramBoolean);
    AppMethodBeat.o(252130);
  }
  
  public final void ac(boolean paramBoolean)
  {
    AppMethodBeat.i(252152);
    if (Build.VERSION.SDK_INT >= 19) {
      this.Ov.setDismissable(paramBoolean);
    }
    AppMethodBeat.o(252152);
  }
  
  public final void ax(View paramView)
  {
    AppMethodBeat.i(252093);
    this.Ox = -1;
    this.Ov.setSource(paramView);
    AppMethodBeat.o(252093);
  }
  
  public final void ay(View paramView)
  {
    AppMethodBeat.i(252094);
    this.Ov.addChild(paramView);
    AppMethodBeat.o(252094);
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(252101);
    if (Build.VERSION.SDK_INT >= 21)
    {
      boolean bool = this.Ov.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.Pn);
      AppMethodBeat.o(252101);
      return bool;
    }
    AppMethodBeat.o(252101);
    return false;
  }
  
  public final void bA(int paramInt)
  {
    AppMethodBeat.i(252097);
    this.Ov.addAction(paramInt);
    AppMethodBeat.o(252097);
  }
  
  @Deprecated
  public final void e(Rect paramRect)
  {
    AppMethodBeat.i(252104);
    this.Ov.getBoundsInParent(paramRect);
    AppMethodBeat.o(252104);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(252154);
    if (this == paramObject)
    {
      AppMethodBeat.o(252154);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(252154);
      return false;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(252154);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.Ov == null)
    {
      if (paramObject.Ov != null)
      {
        AppMethodBeat.o(252154);
        return false;
      }
    }
    else if (!this.Ov.equals(paramObject.Ov))
    {
      AppMethodBeat.o(252154);
      return false;
    }
    if (this.Ox != paramObject.Ox)
    {
      AppMethodBeat.o(252154);
      return false;
    }
    if (this.Ow != paramObject.Ow)
    {
      AppMethodBeat.o(252154);
      return false;
    }
    AppMethodBeat.o(252154);
    return true;
  }
  
  public final void f(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(252159);
    Bundle localBundle = getExtras();
    int j;
    if (localBundle != null)
    {
      j = localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
      if (!paramBoolean) {
        break label57;
      }
    }
    label57:
    for (int i = paramInt;; i = 0)
    {
      localBundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", j & (paramInt ^ 0xFFFFFFFF) | i);
      AppMethodBeat.o(252159);
      return;
    }
  }
  
  @Deprecated
  public final void f(Rect paramRect)
  {
    AppMethodBeat.i(252106);
    this.Ov.setBoundsInParent(paramRect);
    AppMethodBeat.o(252106);
  }
  
  public final void g(Rect paramRect)
  {
    AppMethodBeat.i(252108);
    this.Ov.getBoundsInScreen(paramRect);
    AppMethodBeat.o(252108);
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(252151);
    if (Build.VERSION.SDK_INT >= 19)
    {
      localBundle = this.Ov.getExtras();
      AppMethodBeat.o(252151);
      return localBundle;
    }
    Bundle localBundle = new Bundle();
    AppMethodBeat.o(252151);
    return localBundle;
  }
  
  public final CharSequence getText()
  {
    AppMethodBeat.i(252138);
    int i;
    if (!F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localObject = F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      List localList1 = F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      List localList2 = F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      List localList3 = F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
      SpannableString localSpannableString = new SpannableString(TextUtils.substring(this.Ov.getText(), 0, this.Ov.getText().length()));
      i = 0;
      for (;;)
      {
        if (i < ((List)localObject).size())
        {
          localSpannableString.setSpan(new a(((Integer)localList3.get(i)).intValue(), this, getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)((List)localObject).get(i)).intValue(), ((Integer)localList1.get(i)).intValue(), ((Integer)localList2.get(i)).intValue());
          i += 1;
          continue;
          i = 0;
          break;
        }
      }
      AppMethodBeat.o(252138);
      return localSpannableString;
    }
    Object localObject = this.Ov.getText();
    AppMethodBeat.o(252138);
    return localObject;
  }
  
  public final void h(Rect paramRect)
  {
    AppMethodBeat.i(252109);
    this.Ov.setBoundsInScreen(paramRect);
    AppMethodBeat.o(252109);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(252153);
    if (this.Ov == null)
    {
      AppMethodBeat.o(252153);
      return 0;
    }
    int i = this.Ov.hashCode();
    AppMethodBeat.o(252153);
    return i;
  }
  
  public final boolean hs()
  {
    AppMethodBeat.i(252116);
    if (Build.VERSION.SDK_INT >= 16)
    {
      boolean bool = this.Ov.isVisibleToUser();
      AppMethodBeat.o(252116);
      return bool;
    }
    AppMethodBeat.o(252116);
    return false;
  }
  
  public final boolean ht()
  {
    AppMethodBeat.i(252119);
    if (Build.VERSION.SDK_INT >= 16)
    {
      boolean bool = this.Ov.isAccessibilityFocused();
      AppMethodBeat.o(252119);
      return bool;
    }
    AppMethodBeat.o(252119);
    return false;
  }
  
  public final void s(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252132);
    this.Ov.setPackageName(paramCharSequence);
    AppMethodBeat.o(252132);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(252110);
    this.Ov.setCheckable(paramBoolean);
    AppMethodBeat.o(252110);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(252125);
    this.Ov.setClickable(paramBoolean);
    AppMethodBeat.o(252125);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252145);
    this.Ov.setContentDescription(paramCharSequence);
    AppMethodBeat.o(252145);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(252129);
    this.Ov.setEnabled(paramBoolean);
    AppMethodBeat.o(252129);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(252112);
    this.Ov.setFocusable(paramBoolean);
    AppMethodBeat.o(252112);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(252127);
    this.Ov.setLongClickable(paramBoolean);
    AppMethodBeat.o(252127);
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(252103);
    this.Ow = -1;
    this.Ov.setParent(paramView);
    AppMethodBeat.o(252103);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(252122);
    this.Ov.setSelected(paramBoolean);
    AppMethodBeat.o(252122);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252139);
    this.Ov.setText(paramCharSequence);
    AppMethodBeat.o(252139);
  }
  
  public final void t(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252134);
    this.Ov.setClassName(paramCharSequence);
    AppMethodBeat.o(252134);
  }
  
  public String toString()
  {
    AppMethodBeat.i(252157);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject1 = new Rect();
    e((Rect)localObject1);
    localStringBuilder.append("; boundsInParent: ".concat(String.valueOf(localObject1)));
    g((Rect)localObject1);
    localStringBuilder.append("; boundsInScreen: ".concat(String.valueOf(localObject1)));
    localStringBuilder.append("; packageName: ").append(this.Ov.getPackageName());
    localStringBuilder.append("; className: ").append(this.Ov.getClassName());
    localStringBuilder.append("; text: ").append(getText());
    localStringBuilder.append("; contentDescription: ").append(this.Ov.getContentDescription());
    Object localObject2 = localStringBuilder.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject1 = this.Ov.getViewIdResourceName();
      ((StringBuilder)localObject2).append((String)localObject1);
      localStringBuilder.append("; checkable: ").append(this.Ov.isCheckable());
      localStringBuilder.append("; checked: ").append(this.Ov.isChecked());
      localStringBuilder.append("; focusable: ").append(this.Ov.isFocusable());
      localStringBuilder.append("; focused: ").append(this.Ov.isFocused());
      localStringBuilder.append("; selected: ").append(this.Ov.isSelected());
      localStringBuilder.append("; clickable: ").append(this.Ov.isClickable());
      localStringBuilder.append("; longClickable: ").append(this.Ov.isLongClickable());
      localStringBuilder.append("; enabled: ").append(this.Ov.isEnabled());
      localStringBuilder.append("; password: ").append(this.Ov.isPassword());
      localStringBuilder.append("; scrollable: " + this.Ov.isScrollable());
      localStringBuilder.append("; [");
      if (Build.VERSION.SDK_INT < 21) {
        break label520;
      }
      localObject2 = hu();
      i = 0;
      label413:
      if (i >= ((List)localObject2).size()) {
        break label575;
      }
      a locala = (a)((List)localObject2).get(i);
      localObject1 = bB(locala.getId());
      if ((!((String)localObject1).equals("ACTION_UNKNOWN")) || (locala.hv() == null)) {
        break label600;
      }
      localObject1 = locala.hv().toString();
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
      i = this.Ov.getActions();
      while (i != 0)
      {
        int k = 1 << Integer.numberOfTrailingZeros(i);
        int j = i & (k ^ 0xFFFFFFFF);
        localStringBuilder.append(bB(k));
        i = j;
        if (j != 0)
        {
          localStringBuilder.append(", ");
          i = j;
        }
      }
      localStringBuilder.append("]");
      localObject1 = localStringBuilder.toString();
      AppMethodBeat.o(252157);
      return localObject1;
    }
  }
  
  public static final class a
  {
    public static final a OA;
    public static final a OB;
    public static final a OC;
    public static final a OD;
    public static final a OE;
    public static final a OF;
    public static final a OG;
    public static final a OH;
    public static final a OI;
    public static final a OJ;
    public static final a OL;
    public static final a OM;
    public static final a OO;
    public static final a OP;
    public static final a OQ;
    public static final a OS;
    public static final a OT;
    public static final a OU;
    public static final a OV;
    public static final a OW;
    public static final a OX;
    public static final a OY;
    public static final a OZ;
    public static final a Oz;
    public static final a Pa;
    public static final a Pb;
    public static final a Pc;
    public static final a Pd;
    public static final a Pe;
    public static final a Pf;
    public static final a Pg;
    public static final a Ph;
    public static final a Pi;
    public static final a Pj;
    public static final a Pk;
    public static final a Pl;
    public static final a Pm;
    final Object Pn;
    private final Class<? extends g.a> Po;
    protected final g Pp;
    private final int mId;
    
    static
    {
      AppMethodBeat.i(252063);
      Oz = new a(1);
      OA = new a(2);
      OB = new a(4);
      OC = new a(8);
      OD = new a(16);
      OE = new a(32);
      OF = new a(64);
      OG = new a(128);
      OH = new a(256, g.b.class);
      OI = new a(512, g.b.class);
      OJ = new a(1024, g.c.class);
      OL = new a(2048, g.c.class);
      OM = new a(4096);
      OO = new a(8192);
      OP = new a(16384);
      OQ = new a(32768);
      OS = new a(65536);
      OT = new a(131072, g.g.class);
      OU = new a(262144);
      OV = new a(524288);
      OW = new a(1048576);
      OX = new a(2097152, g.h.class);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        OY = new a(localAccessibilityAction, 16908342, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label690;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        label324:
        OZ = new a(localAccessibilityAction, 16908343, g.e.class);
        if (Build.VERSION.SDK_INT < 23) {
          break label695;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        label351:
        Pa = new a(localAccessibilityAction, 16908344, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label700;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        label377:
        Pb = new a(localAccessibilityAction, 16908345, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label705;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        label403:
        Pc = new a(localAccessibilityAction, 16908346, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label710;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        label429:
        Pd = new a(localAccessibilityAction, 16908347, null);
        if (Build.VERSION.SDK_INT < 29) {
          break label715;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
        label455:
        Pe = new a(localAccessibilityAction, 16908358, null);
        if (Build.VERSION.SDK_INT < 29) {
          break label720;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
        label481:
        Pf = new a(localAccessibilityAction, 16908359, null);
        if (Build.VERSION.SDK_INT < 29) {
          break label725;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
        label507:
        Pg = new a(localAccessibilityAction, 16908360, null);
        if (Build.VERSION.SDK_INT < 29) {
          break label730;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
        label533:
        Ph = new a(localAccessibilityAction, 16908361, null);
        if (Build.VERSION.SDK_INT < 23) {
          break label735;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        label559:
        Pi = new a(localAccessibilityAction, 16908348, null);
        if (Build.VERSION.SDK_INT < 24) {
          break label740;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        label585:
        Pj = new a(localAccessibilityAction, 16908349, g.f.class);
        if (Build.VERSION.SDK_INT < 26) {
          break label745;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        label612:
        Pk = new a(localAccessibilityAction, 16908354, g.d.class);
        if (Build.VERSION.SDK_INT < 28) {
          break label750;
        }
        localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
        label639:
        Pl = new a(localAccessibilityAction, 16908356, null);
        if (Build.VERSION.SDK_INT < 28) {
          break label755;
        }
      }
      label690:
      label695:
      label700:
      label705:
      label710:
      label715:
      label720:
      label725:
      label730:
      label735:
      label740:
      label745:
      label750:
      label755:
      for (AccessibilityNodeInfo.AccessibilityAction localAccessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;; localAccessibilityAction = null)
      {
        Pm = new a(localAccessibilityAction, 16908357, null);
        AppMethodBeat.o(252063);
        return;
        localAccessibilityAction = null;
        break;
        localAccessibilityAction = null;
        break label324;
        localAccessibilityAction = null;
        break label351;
        localAccessibilityAction = null;
        break label377;
        localAccessibilityAction = null;
        break label403;
        localAccessibilityAction = null;
        break label429;
        localAccessibilityAction = null;
        break label455;
        localAccessibilityAction = null;
        break label481;
        localAccessibilityAction = null;
        break label507;
        localAccessibilityAction = null;
        break label533;
        localAccessibilityAction = null;
        break label559;
        localAccessibilityAction = null;
        break label585;
        localAccessibilityAction = null;
        break label612;
        localAccessibilityAction = null;
        break label639;
      }
    }
    
    private a(int paramInt)
    {
      this(null, paramInt, null);
    }
    
    private a(int paramInt, Class<? extends g.a> paramClass)
    {
      this(null, paramInt, paramClass);
    }
    
    a(Object paramObject)
    {
      this(paramObject, 0, null);
    }
    
    private a(Object paramObject, int paramInt, Class<? extends g.a> paramClass)
    {
      AppMethodBeat.i(252052);
      this.mId = paramInt;
      this.Pp = null;
      if ((Build.VERSION.SDK_INT >= 21) && (paramObject == null)) {}
      for (this.Pn = new AccessibilityNodeInfo.AccessibilityAction(paramInt, null);; this.Pn = paramObject)
      {
        this.Po = paramClass;
        AppMethodBeat.o(252052);
        return;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(252061);
      if (paramObject == null)
      {
        AppMethodBeat.o(252061);
        return false;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(252061);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.Pn == null)
      {
        if (paramObject.Pn != null)
        {
          AppMethodBeat.o(252061);
          return false;
        }
      }
      else if (!this.Pn.equals(paramObject.Pn))
      {
        AppMethodBeat.o(252061);
        return false;
      }
      AppMethodBeat.o(252061);
      return true;
    }
    
    public final int getId()
    {
      AppMethodBeat.i(252053);
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i = ((AccessibilityNodeInfo.AccessibilityAction)this.Pn).getId();
        AppMethodBeat.o(252053);
        return i;
      }
      AppMethodBeat.o(252053);
      return 0;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(252060);
      if (this.Pn != null)
      {
        int i = this.Pn.hashCode();
        AppMethodBeat.o(252060);
        return i;
      }
      AppMethodBeat.o(252060);
      return 0;
    }
    
    public final CharSequence hv()
    {
      AppMethodBeat.i(252055);
      if (Build.VERSION.SDK_INT >= 21)
      {
        CharSequence localCharSequence = ((AccessibilityNodeInfo.AccessibilityAction)this.Pn).getLabel();
        AppMethodBeat.o(252055);
        return localCharSequence;
      }
      AppMethodBeat.o(252055);
      return null;
    }
    
    public final boolean i(Bundle paramBundle)
    {
      AppMethodBeat.i(252058);
      if (this.Pp != null)
      {
        if (this.Po != null) {}
        try
        {
          ((g.a)this.Po.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).mBundle = paramBundle;
          boolean bool = this.Pp.hx();
          AppMethodBeat.o(252058);
          return bool;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            if (this.Po != null) {
              this.Po.getName();
            }
          }
        }
      }
      AppMethodBeat.o(252058);
      return false;
    }
  }
  
  public static final class c
  {
    final Object Pq;
    
    private c(Object paramObject)
    {
      this.Pq = paramObject;
    }
    
    public static c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      AppMethodBeat.i(252066);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localc = new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, false));
        AppMethodBeat.o(252066);
        return localc;
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        localc = new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
        AppMethodBeat.o(252066);
        return localc;
      }
      c localc = new c(null);
      AppMethodBeat.o(252066);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.a.d
 * JD-Core Version:    0.7.0.1
 */