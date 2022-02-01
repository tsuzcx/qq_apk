package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFloatMiniViewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "videoFloatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "addVideoFloatBall", "", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isFromHorizontal", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends UIComponent
{
  public static final a GQa;
  private dnq EAN;
  
  static
  {
    AppMethodBeat.i(337988);
    GQa = new a((byte)0);
    AppMethodBeat.o(337988);
  }
  
  public x(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337961);
    paramAppCompatActivity = new dnq();
    Object localObject = z.FrZ;
    paramAppCompatActivity.key = z.bUm();
    localObject = ah.aiuX;
    this.EAN = paramAppCompatActivity;
    AppMethodBeat.o(337961);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFloatMiniViewUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.x
 * JD-Core Version:    0.7.0.1
 */