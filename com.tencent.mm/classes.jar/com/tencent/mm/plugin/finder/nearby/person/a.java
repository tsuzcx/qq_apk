package com.tencent.mm.plugin.finder.nearby.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.nearby.model.c;
import com.tencent.mm.plugin.nearby.model.d;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "adItemList", "", "", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData;", "getAdItemList", "()Ljava/util/Map;", "sceneClearLocation", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "getSceneClearLocation", "()Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "setSceneClearLocation", "(Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;)V", "sceneJoinLbsRoom", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;", "getSceneJoinLbsRoom", "()Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;", "setSceneJoinLbsRoom", "(Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;)V", "sceneLbsFind", "getSceneLbsFind", "setSceneLbsFind", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ADData", "Companion", "Location", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends UIComponent
  implements h
{
  public static final a.b EOL;
  private c EOM;
  private c EON;
  private d EOO;
  final Map<String, a> EOP;
  
  static
  {
    AppMethodBeat.i(339849);
    EOL = new a.b((byte)0);
    AppMethodBeat.o(339849);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(339837);
    this.EOP = ((Map)new HashMap());
    AppMethodBeat.o(339837);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(339844);
    this.EOP = ((Map)new HashMap());
    AppMethodBeat.o(339844);
  }
  
  protected final void a(c paramc)
  {
    this.EOM = paramc;
  }
  
  protected final void a(d paramd)
  {
    this.EOO = paramd;
  }
  
  protected final void b(c paramc)
  {
    this.EON = paramc;
  }
  
  protected final c eFZ()
  {
    return this.EOM;
  }
  
  protected final c eGa()
  {
    return this.EON;
  }
  
  protected final d eGb()
  {
    return this.EOO;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(339885);
    s.u(paramp, "scene");
    AppMethodBeat.o(339885);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData;", "", "()V", "closeCount", "", "getCloseCount", "()I", "setCloseCount", "(I)V", "closeTimes", "getCloseTimes", "setCloseTimes", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "hide", "", "getHide", "()Z", "setHide", "(Z)V", "icon", "getIcon", "setIcon", "id", "getId", "setId", "jumpVal", "getJumpVal", "setJumpVal", "jump_type", "getJump_type", "setJump_type", "name", "getName", "setName", "pos", "getPos", "setPos", "showCount", "getShowCount", "setShowCount", "showTimes", "getShowTimes", "setShowTimes", "stat", "getStat", "setStat", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a.a.a EOQ;
    int EOR;
    int EOS;
    String EOT;
    int EOU;
    int EOV = -1;
    String desc;
    String icon;
    String id;
    int jump_type;
    String name;
    int pos;
    boolean uPP;
    int wDI;
    
    static
    {
      AppMethodBeat.i(339853);
      EOQ = new a.a.a((byte)0);
      AppMethodBeat.o(339853);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Location;", "", "lat", "", "lng", "accuracy", "", "(FFI)V", "getAccuracy", "()I", "setAccuracy", "(I)V", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    int EOW;
    float oDT;
    float oDU;
    
    public c(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.oDT = paramFloat1;
      this.oDU = paramFloat2;
      this.EOW = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.a
 * JD-Core Version:    0.7.0.1
 */