package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.protocal.protobuf.dyg;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cr;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class u
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final com.tencent.mm.am.c rr;
  
  public u()
  {
    AppMethodBeat.i(151228);
    c.a locala = new c.a();
    locala.otE = new dyg();
    locala.otF = new dyh();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.funcId = 810;
    this.rr = locala.bEF();
    ((dyg)c.b.b(this.rr.otB)).selector = 2097152;
    Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(151228);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(151229);
    com.tencent.mm.kernel.h.baF();
    byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, null)));
    gol localgol = new gol();
    localgol.df(arrayOfByte);
    ((dyg)c.b.b(this.rr.otB)).abdy = localgol;
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151229);
    return i;
  }
  
  public final int getType()
  {
    return 810;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151230);
    Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151230);
      return;
    }
    paramString = (dyg)c.b.b(this.rr.otB);
    params = (dyh)c.c.b(this.rr.otC);
    if ((params.abdz != null) && (params.abdz.vgO.size() > 0))
    {
      Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(params.abdz.vgO.size()) });
      paramArrayOfByte = params.abdz.vgO.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (adw)paramArrayOfByte.next();
        Object localObject2;
        if (((adw)localObject1).Zmc == 400)
        {
          localObject2 = new dxi();
          for (;;)
          {
            Object localObject3;
            try
            {
              ((dxi)localObject2).parseFrom(((adw)localObject1).Zmd.aaxD.Op);
              Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((dxi)localObject2).psp });
              localObject1 = v.c((dxi)localObject2);
              Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((az)localObject1).field_username, ((az)localObject1).field_nickname, ((az)localObject1).field_conRemark, Integer.valueOf(((au)localObject1).getSource()), Integer.valueOf(((az)localObject1).sex), ((az)localObject1).field_openImAppid, ((az)localObject1).kav, Integer.valueOf(((az)localObject1).kau), Integer.valueOf(((az)localObject1).field_type), ((az)localObject1).field_descWordingId });
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aA((au)localObject1);
              if (com.tencent.mm.contact.d.rs(((az)localObject1).field_type))
              {
                str = ((az)localObject1).field_username;
                localObject3 = (bo)((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaX();
                if (localObject3 != null)
                {
                  bool = ((com.tencent.mm.plugin.messenger.foundation.a.a.d)localObject3).fP(str, 1);
                  if (!bool) {
                    break label711;
                  }
                  Log.d("MicroMsg.Openim.NetsceneOpenIMSync", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
                  Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
                }
              }
              if (!((au)localObject1).aSQ()) {
                break label749;
              }
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxT(((az)localObject1).field_username);
              ((e)com.tencent.mm.kernel.h.ax(e.class)).cb(((dxi)localObject2).app_id, ((dxi)localObject2).abdn);
              v.d((dxi)localObject2);
              v.a((dxi)localObject2);
              v.b((dxi)localObject2);
              com.tencent.mm.kernel.h.baF();
              localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(((az)localObject1).field_username);
              if ((localObject2 == null) || (Util.isNullOrNil(((cr)localObject2).field_encryptUsername))) {
                break;
              }
              localObject3 = ((cr)localObject2).field_conRemark;
              ((com.tencent.mm.plugin.messenger.foundation.a.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.u.class)).aw(((az)localObject1).field_username, (String)localObject3);
              com.tencent.mm.kernel.h.baF();
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMj(((az)localObject1).field_username);
              ((au)localObject1).AW(((cr)localObject2).field_conRemark);
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aA((au)localObject1);
            }
            catch (IOException localIOException1)
            {
              Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
            }
            break;
            label711:
            String str = localIOException1.field_encryptUsername;
            boolean bool = ((com.tencent.mm.plugin.messenger.foundation.a.a.d)localObject3).fP(str, 1);
            Log.d("MicroMsg.Openim.NetsceneOpenIMSync", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(str)));
            continue;
            label749:
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxU(localIOException1.field_username);
          }
        }
        if (localIOException1.Zmc == 402)
        {
          localObject2 = new ais();
          try
          {
            ((ais)localObject2).parseFrom(localIOException1.Zmd.aaxD.Op);
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((ais)localObject2).psp });
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxK(((ais)localObject2).psp);
            ab.IU(((ais)localObject2).psp);
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.Zmc == 403)
        {
          try
          {
            localObject2 = new dxc();
            ((dxc)localObject2).parseFrom(localIOException2.Zmd.aaxD.Op);
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((dxc)localObject2).pss });
            a.a((dxc)localObject2, -1, ((dxc)localObject2).abcX);
          }
          catch (IOException localIOException3)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
        else if (localIOException3.Zmc == 404)
        {
          localObject2 = new dxi();
          try
          {
            ((dxi)localObject2).parseFrom(localIOException3.Zmd.aaxD.Op);
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", new Object[] { ((dxi)localObject2).psp });
            com.tencent.mm.kernel.h.baD().mCm.a(new j(((dxi)localObject2).psp, "", ""), 0);
          }
          catch (IOException localIOException4)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", new Object[] { localIOException4 });
          }
        }
      }
    }
    paramArrayOfByte = params.abdy.aaxD.toByteArray();
    if (paramArrayOfByte != null)
    {
      com.tencent.mm.kernel.h.baF();
      paramArrayOfByte = ad.o(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, null))), paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().B(8195, Util.encodeHexString(paramArrayOfByte));
      }
    }
    paramInt1 = params.BeA;
    if ((paramString.selector & paramInt1) == 0)
    {
      Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(151230);
      return;
    }
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(151230);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.u
 * JD-Core Version:    0.7.0.1
 */