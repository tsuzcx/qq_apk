package com.tencent.mm.plugin.hashinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.hashinfo.b.a.c.a;
import com.tencent.mm.plugin.hashinfo.b.a.c.b;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hashinfo/PluginHashInfo;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/hashinfo/api/IPluginHashInfo;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "Lcom/tencent/mm/kernel/api/ICollectDBFactory;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/pluginsdk/oplog/IDeleteContactService$IDeleteContactResult;", "()V", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getContactByHash", "Lcom/tencent/mm/storage/Contact;", "hashUserName", "", "hashType", "getNameMapStorage", "Lcom/tencent/mm/plugin/hashinfo/model/storage/HashUserNameMapStorage;", "getUserNameByHash", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDeleteContact", "username", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parallelsDependency", "remove", "userName", "Companion", "plugin-hashinfo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginHashInfo
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.am.h, b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.hashinfo.a.a, com.tencent.mm.pluginsdk.i.a.a
{
  public static final PluginHashInfo.a JmJ;
  
  static
  {
    AppMethodBeat.i(261042);
    JmJ = new PluginHashInfo.a((byte)0);
    AppMethodBeat.o(261042);
  }
  
  private final com.tencent.mm.plugin.hashinfo.b.a.c getNameMapStorage()
  {
    AppMethodBeat.i(261032);
    Object localObject = com.tencent.mm.plugin.ac.a.MnH;
    localObject = (com.tencent.mm.plugin.hashinfo.b.a.c)((com.tencent.mm.plugin.ac.a)com.tencent.mm.plugin.ac.a.a.bW(com.tencent.mm.plugin.hashinfo.b.a.a.class)).bV(com.tencent.mm.plugin.hashinfo.b.a.c.class);
    AppMethodBeat.o(261032);
    return localObject;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return null;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final au getContactByHash(String paramString, int paramInt)
  {
    AppMethodBeat.i(261055);
    com.tencent.mm.plugin.hashinfo.b.a.c localc = getNameMapStorage();
    if (localc != null)
    {
      paramString = localc.getUserNameByHash(paramString, paramInt);
      if (paramString != null)
      {
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(paramString);
        if (com.tencent.mm.contact.d.rs(paramString.field_type))
        {
          AppMethodBeat.o(261055);
          return paramString;
        }
        AppMethodBeat.o(261055);
        return null;
      }
    }
    AppMethodBeat.o(261055);
    return null;
  }
  
  public final String getUserNameByHash(String paramString, int paramInt)
  {
    AppMethodBeat.i(261049);
    com.tencent.mm.plugin.hashinfo.b.a.c localc = getNameMapStorage();
    if (localc == null)
    {
      AppMethodBeat.o(261049);
      return null;
    }
    paramString = localc.getUserNameByHash(paramString, paramInt);
    AppMethodBeat.o(261049);
    return paramString;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(261066);
    paramc = com.tencent.mm.plugin.ac.a.MnH;
    paramc = (com.tencent.mm.plugin.hashinfo.b.a.a)com.tencent.mm.plugin.ac.a.a.bW(com.tencent.mm.plugin.hashinfo.b.a.a.class);
    c.a locala = com.tencent.mm.plugin.hashinfo.b.a.c.JmN;
    paramc.aPK(com.tencent.mm.plugin.hashinfo.b.a.c.fKn());
    com.tencent.mm.kernel.h.aZW().a(302, (com.tencent.mm.am.h)this);
    ((com.tencent.mm.plugin.messenger.foundation.a.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.g.class)).addContactAssembler((com.tencent.mm.plugin.messenger.foundation.a.f)new b(this));
    ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).a((com.tencent.mm.pluginsdk.i.a.a)this);
    AppMethodBeat.o(261066);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(261070);
    com.tencent.mm.kernel.h.aZW().b(302, (com.tencent.mm.am.h)this);
    ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).b((com.tencent.mm.pluginsdk.i.a.a)this);
    AppMethodBeat.o(261070);
  }
  
  public final void onDeleteContact(String paramString, int paramInt, dzc paramdzc)
  {
    AppMethodBeat.i(261098);
    Log.d("MicroMsg.HashInfo.PluginHashInfo", "onDeleteContact() called with: username = " + paramString + ", ret = " + paramInt + ", oplogErrMsg = " + paramdzc);
    if (paramInt == 0)
    {
      paramdzc = (CharSequence)paramString;
      if ((paramdzc != null) && (!kotlin.n.n.bp(paramdzc))) {
        break label81;
      }
    }
    label81:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        remove(paramString);
      }
      AppMethodBeat.o(261098);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(261089);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramp instanceof q)) {
        break label120;
      }
      paramString = (q)paramp;
      if (paramString != null) {
        break label125;
      }
      paramString = null;
      label33:
      if (!(paramString instanceof com.tencent.mm.am.c)) {
        break label133;
      }
      paramString = (com.tencent.mm.am.c)paramString;
      label45:
      if (paramString != null) {
        break label138;
      }
      paramString = null;
      label51:
      if (!(paramString instanceof cqe)) {
        break label149;
      }
      paramString = (cqe)paramString;
      label63:
      if (paramString == null) {
        break label154;
      }
    }
    label133:
    label138:
    label149:
    label154:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.HashInfo.PluginHashInfo", kotlin.g.b.s.X("afterNetSceneGetProfile resp:", Boolean.valueOf(bool)));
      if (paramString != null)
      {
        paramString = getNameMapStorage();
        paramp = com.tencent.mm.plugin.auth.a.a.cUx();
        kotlin.g.b.s.s(paramp, "username()");
        paramString.Ds(paramp);
      }
      AppMethodBeat.o(261089);
      return;
      label120:
      paramString = null;
      break;
      label125:
      paramString = paramString.getReqResp();
      break label33;
      paramString = null;
      break label45;
      paramString = c.c.b(paramString.otC);
      break label51;
      paramString = null;
      break label63;
    }
  }
  
  public final void parallelsDependency() {}
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(261062);
    com.tencent.mm.plugin.hashinfo.b.a.c localc = getNameMapStorage();
    if (localc != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
        break label65;
      }
    }
    label65:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.mm.ae.d.d("MicroMsg.HashInfo.HashUserNameMapStorage", (kotlin.g.a.a)new c.b(localc, paramString));
      }
      AppMethodBeat.o(261062);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hashinfo/PluginHashInfo$onAccountInitialized$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/IContactSyncCallback;", "afterContactUpdate", "", "newContact", "Lcom/tencent/mm/storage/Contact;", "oldContact", "cmdMC", "Lcom/tencent/mm/protocal/protobuf/ModContact;", "cmdBuf", "", "isInit", "", "assemble", "beforeContactDel", "Lcom/tencent/mm/protocal/protobuf/DelContact;", "plugin-hashinfo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.messenger.foundation.a.f
  {
    b(PluginHashInfo paramPluginHashInfo) {}
    
    public final void a(au paramau, aid paramaid) {}
    
    public final void a(au paramau1, au paramau2, dph paramdph, byte[] paramArrayOfByte, boolean paramBoolean) {}
    
    public final void b(au paramau1, au paramau2, dph paramdph, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(261040);
      if (paramdph != null)
      {
        paramau2 = this.JmK;
        if ((paramau1 != null) && (com.tencent.mm.contact.d.rs(paramau1.field_type)))
        {
          Log.d("MicroMsg.HashInfo.PluginHashInfo", kotlin.g.b.s.X("afterContactUpdate update ", paramau1.field_username));
          paramau2 = PluginHashInfo.access$getNameMapStorage(paramau2);
          if (paramau2 != null)
          {
            paramau1 = paramau1.field_username;
            kotlin.g.b.s.s(paramau1, "newContact.username");
            paramau2.Ds(paramau1);
          }
        }
      }
      AppMethodBeat.o(261040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hashinfo.PluginHashInfo
 * JD-Core Version:    0.7.0.1
 */