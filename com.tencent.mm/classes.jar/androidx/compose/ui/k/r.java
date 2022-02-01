package androidx.compose.ui.k;

import androidx.compose.ui.m.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/SemanticsProperties;", "", "()V", "CollectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "CollectionItemInfo", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "getCollectionItemInfo", "ContentDescription", "", "", "getContentDescription", "Disabled", "", "getDisabled", "EditableText", "Landroidx/compose/ui/text/AnnotatedString;", "getEditableText", "Error", "getError", "Focused", "", "getFocused", "Heading", "getHeading", "HorizontalScrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "getHorizontalScrollAxisRange", "ImeAction", "Landroidx/compose/ui/text/input/ImeAction;", "getImeAction", "IndexForKey", "Lkotlin/Function1;", "", "getIndexForKey", "InvisibleToUser", "getInvisibleToUser$annotations", "getInvisibleToUser", "IsDialog", "getIsDialog", "IsPopup", "getIsPopup", "LiveRegion", "Landroidx/compose/ui/semantics/LiveRegionMode;", "getLiveRegion", "PaneTitle", "getPaneTitle", "Password", "getPassword", "ProgressBarRangeInfo", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getProgressBarRangeInfo", "Role", "Landroidx/compose/ui/semantics/Role;", "getRole", "SelectableGroup", "getSelectableGroup", "Selected", "getSelected", "StateDescription", "getStateDescription", "TestTag", "getTestTag", "Text", "getText", "TextSelectionRange", "Landroidx/compose/ui/text/TextRange;", "getTextSelectionRange", "ToggleableState", "Landroidx/compose/ui/state/ToggleableState;", "getToggleableState", "VerticalScrollAxisRange", "getVerticalScrollAxisRange", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  private static final t<b> aXA;
  private static final t<c> aXB;
  private static final t<ah> aXC;
  private static final t<ah> aXD;
  private static final t<d> aXE;
  private static final t<Boolean> aXF;
  private static final t<ah> aXG;
  private static final t<h> aXH;
  private static final t<h> aXI;
  private static final t<ah> aXJ;
  private static final t<ah> aXK;
  private static final t<g> aXL;
  private static final t<String> aXM;
  private static final t<List<androidx.compose.ui.m.a>> aXN;
  private static final t<androidx.compose.ui.m.a> aXO;
  private static final t<s> aXP;
  private static final t<androidx.compose.ui.m.c.f> aXQ;
  private static final t<Boolean> aXR;
  private static final t<androidx.compose.ui.l.a> aXS;
  private static final t<ah> aXT;
  private static final t<String> aXU;
  private static final t<kotlin.g.a.b<Object, Integer>> aXV;
  public static final r aXu;
  private static final t<List<String>> aXv;
  private static final t<String> aXw;
  private static final t<f> aXx;
  private static final t<String> aXy;
  private static final t<ah> aXz;
  
  static
  {
    AppMethodBeat.i(205559);
    aXu = new r();
    aXv = new t("ContentDescription", (m)r.a.aXW);
    aXw = new t("StateDescription");
    aXx = new t("ProgressBarRangeInfo");
    aXy = new t("PaneTitle", (m)r.e.aYa);
    aXz = new t("SelectableGroup");
    aXA = new t("CollectionInfo");
    aXB = new t("CollectionItemInfo");
    aXC = new t("Heading");
    aXD = new t("Disabled");
    aXE = new t("LiveRegion");
    aXF = new t("Focused");
    aXG = new t("InvisibleToUser", (m)r.b.aXX);
    aXH = new t("HorizontalScrollAxisRange");
    aXI = new t("VerticalScrollAxisRange");
    aXJ = new t("IsPopup", (m)r.d.aXZ);
    aXK = new t("IsDialog", (m)r.c.aXY);
    aXL = new t("Role", (m)r.f.aYb);
    aXM = new t("TestTag", (m)r.g.aYc);
    aXN = new t("Text", (m)r.h.aYd);
    aXO = new t("EditableText");
    aXP = new t("TextSelectionRange");
    aXQ = new t("ImeAction");
    aXR = new t("Selected");
    aXS = new t("ToggleableState");
    aXT = new t("Password");
    aXU = new t("Error");
    aXV = new t("IndexForKey");
    AppMethodBeat.o(205559);
  }
  
  public static t<androidx.compose.ui.l.a> AA()
  {
    return aXS;
  }
  
  public static t<ah> AB()
  {
    return aXT;
  }
  
  public static t<String> AC()
  {
    return aXU;
  }
  
  public static t<kotlin.g.a.b<Object, Integer>> AD()
  {
    return aXV;
  }
  
  public static t<List<String>> Af()
  {
    return aXv;
  }
  
  public static t<String> Ag()
  {
    return aXw;
  }
  
  public static t<f> Ah()
  {
    return aXx;
  }
  
  public static t<String> Ai()
  {
    return aXy;
  }
  
  public static t<ah> Aj()
  {
    return aXz;
  }
  
  public static t<b> Ak()
  {
    return aXA;
  }
  
  public static t<c> Al()
  {
    return aXB;
  }
  
  public static t<ah> Am()
  {
    return aXC;
  }
  
  public static t<ah> An()
  {
    return aXD;
  }
  
  public static t<d> Ao()
  {
    return aXE;
  }
  
  public static t<Boolean> Ap()
  {
    return aXF;
  }
  
  public static t<ah> Aq()
  {
    return aXG;
  }
  
  public static t<h> Ar()
  {
    return aXH;
  }
  
  public static t<h> As()
  {
    return aXI;
  }
  
  public static t<g> At()
  {
    return aXL;
  }
  
  public static t<String> Au()
  {
    return aXM;
  }
  
  public static t<List<androidx.compose.ui.m.a>> Av()
  {
    return aXN;
  }
  
  public static t<androidx.compose.ui.m.a> Aw()
  {
    return aXO;
  }
  
  public static t<s> Ax()
  {
    return aXP;
  }
  
  public static t<androidx.compose.ui.m.c.f> Ay()
  {
    return aXQ;
  }
  
  public static t<Boolean> Az()
  {
    return aXR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.r
 * JD-Core Version:    0.7.0.1
 */