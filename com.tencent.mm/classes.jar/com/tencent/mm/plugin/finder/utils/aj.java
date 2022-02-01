package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.storage.config.base.c;
import com.tencent.mm.protocal.protobuf.FinderTipsShowDiscoveryExtInfo;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxq;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderRedDotGenerate;", "", "()V", "FINDER_FOLLOW_ENTRANCE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "getFINDER_FOLLOW_ENTRANCE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "FINDER_FRIEND_ENTRANCE", "getFINDER_FRIEND_ENTRANCE", "FINDER_MACHINE_ENTRANCE", "getFINDER_MACHINE_ENTRANCE", "generateMachineRedDot", "", "tabType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
{
  public static final aj Ght;
  private static final c Ghu;
  private static final c Ghv;
  private static final c Ghw;
  
  static
  {
    AppMethodBeat.i(333604);
    Ght = new aj();
    Ghu = new c("生成 - 视频号 - 推荐红点", (kotlin.g.a.b)c.Ghz);
    Ghv = new c("生成 - 视频号 - 朋友红点", (kotlin.g.a.b)b.Ghy);
    Ghw = new c("生成 - 视频号 - 关注红点", (kotlin.g.a.b)a.Ghx);
    AppMethodBeat.o(333604);
  }
  
  public static void TW(int paramInt)
  {
    AppMethodBeat.i(333558);
    Object localObject2 = new btx();
    ((btx)localObject2).aabK = 0;
    ((btx)localObject2).object_id = -4713593823100200908L;
    ((btx)localObject2).tab_type = paramInt;
    ((btx)localObject2).object_nonce_id = "";
    ((btx)localObject2).YIZ = "";
    ((btx)localObject2).aabM = null;
    ((btx)localObject2).aabN = null;
    ((btx)localObject2).aabO = 0;
    ((btx)localObject2).aabL = 0;
    Object localObject1 = new btw();
    ((btw)localObject1).ZYN = String.valueOf(com.tencent.mm.model.cn.bDw());
    ((btw)localObject1).priority = 400000;
    ((btw)localObject1).type = 10;
    ((btw)localObject1).aabz = new com.tencent.mm.bx.b(((btx)localObject2).toByteArray());
    localObject2 = new bxq();
    ((bxq)localObject2).show_type = 3;
    ((bxq)localObject2).aagq = 1;
    ((bxq)localObject2).path = "FinderEntrance";
    ((bxq)localObject2).Nnp = "Discovery";
    ((bxq)localObject2).title = "RedDot";
    ((btw)localObject1).aabA.add(localObject2);
    localObject2 = new bxq();
    ((bxq)localObject2).show_type = 1;
    ((bxq)localObject2).aagq = 1;
    ((bxq)localObject2).path = "finder_tl_hot_tab";
    ((bxq)localObject2).Nnp = "FinderEntrance";
    ((btw)localObject1).aabA.add(localObject2);
    localObject2 = new bxq();
    ((bxq)localObject2).show_type = 1;
    ((bxq)localObject2).aagq = 2;
    ((bxq)localObject2).path = "Discovery";
    ((bxq)localObject2).Nnp = null;
    ((bxq)localObject2).aagr = 3;
    Object localObject3 = new FinderTipsShowDiscoveryExtInfo();
    ((FinderTipsShowDiscoveryExtInfo)localObject3).show_ext_info = "RedDot";
    ((bxq)localObject2).aags = new com.tencent.mm.bx.b(((FinderTipsShowDiscoveryExtInfo)localObject3).toByteArray());
    ((btw)localObject1).aabA.add(localObject2);
    localObject2 = new bxh();
    localObject3 = new LinkedList();
    bxi localbxi = new bxi();
    localbxi.aagf = ((btw)localObject1);
    localObject1 = ah.aiuX;
    ((LinkedList)localObject3).add(localbxi);
    localObject1 = ah.aiuX;
    ((bxh)localObject2).aace = ((LinkedList)localObject3);
    ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().a((bxh)localObject2, "notify1");
    AppMethodBeat.o(333558);
  }
  
  public static c ffi()
  {
    return Ghu;
  }
  
  public static c ffj()
  {
    return Ghv;
  }
  
  public static c ffk()
  {
    return Ghw;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final a Ghx;
    
    static
    {
      AppMethodBeat.i(333762);
      Ghx = new a();
      AppMethodBeat.o(333762);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final b Ghy;
    
    static
    {
      AppMethodBeat.i(333778);
      Ghy = new b();
      AppMethodBeat.o(333778);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final c Ghz;
    
    static
    {
      AppMethodBeat.i(333791);
      Ghz = new c();
      AppMethodBeat.o(333791);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aj
 * JD-Core Version:    0.7.0.1
 */