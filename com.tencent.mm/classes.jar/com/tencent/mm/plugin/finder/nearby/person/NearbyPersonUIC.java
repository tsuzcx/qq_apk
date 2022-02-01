package com.tencent.mm.plugin.finder.nearby.person;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.nearby.a.d;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "adItemList", "", "", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData;", "getAdItemList", "()Ljava/util/Map;", "sceneClearLocation", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "getSceneClearLocation", "()Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "setSceneClearLocation", "(Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;)V", "sceneJoinLbsRoom", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;", "getSceneJoinLbsRoom", "()Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;", "setSceneJoinLbsRoom", "(Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;)V", "sceneLbsFind", "getSceneLbsFind", "setSceneLbsFind", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ADData", "Companion", "Location", "plugin-finder_release"})
public class NearbyPersonUIC
  extends UIComponent
  implements i
{
  public static final NearbyPersonUIC.b uRZ;
  c uRV;
  c uRW;
  d uRX;
  final Map<String, a> uRY;
  
  static
  {
    AppMethodBeat.i(249264);
    uRZ = new NearbyPersonUIC.b((byte)0);
    AppMethodBeat.o(249264);
  }
  
  public NearbyPersonUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(249263);
    this.uRY = ((Map)new HashMap());
    AppMethodBeat.o(249263);
  }
  
  public NearbyPersonUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(249262);
    this.uRY = ((Map)new HashMap());
    AppMethodBeat.o(249262);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(249261);
    p.h(paramq, "scene");
    AppMethodBeat.o(249261);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData;", "", "()V", "closeCount", "", "getCloseCount", "()I", "setCloseCount", "(I)V", "closeTimes", "getCloseTimes", "setCloseTimes", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "hide", "", "getHide", "()Z", "setHide", "(Z)V", "icon", "getIcon", "setIcon", "id", "getId", "setId", "jumpVal", "getJumpVal", "setJumpVal", "jump_type", "getJump_type", "setJump_type", "name", "getName", "setName", "pos", "getPos", "setPos", "showCount", "getShowCount", "setShowCount", "showTimes", "getShowTimes", "setShowTimes", "stat", "getStat", "setStat", "Companion", "plugin-finder_release"})
  public static final class a
  {
    public static final NearbyPersonUIC.a.a uSg;
    String desc;
    String icon;
    String id;
    String name;
    boolean oBV;
    int pos;
    int qdp;
    int uSa;
    int uSb;
    int uSc;
    String uSd;
    int uSe;
    int uSf = -1;
    
    static
    {
      AppMethodBeat.i(249260);
      uSg = new NearbyPersonUIC.a.a((byte)0);
      AppMethodBeat.o(249260);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Location;", "", "lat", "", "lng", "accuracy", "", "(FFI)V", "getAccuracy", "()I", "setAccuracy", "(I)V", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "plugin-finder_release"})
  public static final class c
  {
    int accuracy;
    float iUY;
    float iUZ;
    
    public c(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.iUY = paramFloat1;
      this.iUZ = paramFloat2;
      this.accuracy = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonUIC
 * JD-Core Version:    0.7.0.1
 */