package com.tencent.mm.plugin.finder.nearby.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.nearby.a.d;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "adItemList", "", "", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData;", "getAdItemList", "()Ljava/util/Map;", "sceneClearLocation", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "getSceneClearLocation", "()Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "setSceneClearLocation", "(Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;)V", "sceneJoinLbsRoom", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;", "getSceneJoinLbsRoom", "()Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;", "setSceneJoinLbsRoom", "(Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;)V", "sceneLbsFind", "getSceneLbsFind", "setSceneLbsFind", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ADData", "Companion", "Location", "plugin-finder-nearby_release"})
public class a
  extends UIComponent
  implements i
{
  public static final a.b zHn;
  c zHj;
  c zHk;
  d zHl;
  final Map<String, a> zHm;
  
  static
  {
    AppMethodBeat.i(200709);
    zHn = new a.b((byte)0);
    AppMethodBeat.o(200709);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(200707);
    this.zHm = ((Map)new HashMap());
    AppMethodBeat.o(200707);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(200708);
    this.zHm = ((Map)new HashMap());
    AppMethodBeat.o(200708);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(200706);
    p.k(paramq, "scene");
    AppMethodBeat.o(200706);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData;", "", "()V", "closeCount", "", "getCloseCount", "()I", "setCloseCount", "(I)V", "closeTimes", "getCloseTimes", "setCloseTimes", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "hide", "", "getHide", "()Z", "setHide", "(Z)V", "icon", "getIcon", "setIcon", "id", "getId", "setId", "jumpVal", "getJumpVal", "setJumpVal", "jump_type", "getJump_type", "setJump_type", "name", "getName", "setName", "pos", "getPos", "setPos", "showCount", "getShowCount", "setShowCount", "showTimes", "getShowTimes", "setShowTimes", "stat", "getStat", "setStat", "Companion", "plugin-finder-nearby_release"})
  public static final class a
  {
    public static final a.a.a zHt;
    String desc;
    String icon;
    String id;
    int jump_type;
    String name;
    int pos;
    boolean rED;
    int tzm;
    int zHo;
    int zHp;
    String zHq;
    int zHr;
    int zHs = -1;
    
    static
    {
      AppMethodBeat.i(200546);
      zHt = new a.a.a((byte)0);
      AppMethodBeat.o(200546);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Location;", "", "lat", "", "lng", "accuracy", "", "(FFI)V", "getAccuracy", "()I", "setAccuracy", "(I)V", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "plugin-finder-nearby_release"})
  public static final class c
  {
    float lLr;
    float lLs;
    int zHu;
    
    public c(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.lLr = paramFloat1;
      this.lLs = paramFloat2;
      this.zHu = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.a
 * JD-Core Version:    0.7.0.1
 */