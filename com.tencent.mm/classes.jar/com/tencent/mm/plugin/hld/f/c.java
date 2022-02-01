package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/ImeUserDictGenerator;", "", "()V", "TAG", "", "UPDATE_CONTACT_MIN_TIME", "", "contactHashmap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "lastContactChangeTime", "onContactChange", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "getOnContactChange", "()Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "isSender", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "loadContact", "", "loadLocalUserDict", "loadPhoneContactData", "refreshPhoneContactByDay", "startGeneratorLocalUserDict", "dict", "updatePhoneContactData", "IPCLoadContactData", "plugin-hld_release"})
public final class c
{
  private static final HashMap<String, Pair<String, String>> DGM;
  private static long DGN;
  public static final c DGO;
  private static final MStorageEx.IOnStorageChange vgY;
  
  static
  {
    AppMethodBeat.i(209691);
    DGO = new c();
    DGM = new HashMap();
    vgY = (MStorageEx.IOnStorageChange)c.DGS;
    AppMethodBeat.o(209691);
  }
  
  public static MStorageEx.IOnStorageChange eFW()
  {
    return vgY;
  }
  
  public static void eFX()
  {
    AppMethodBeat.i(209684);
    com.tencent.mm.plugin.hld.model.p localp = com.tencent.mm.plugin.hld.model.p.DEH;
    if (com.tencent.mm.plugin.hld.model.p.eFn())
    {
      AppMethodBeat.o(209684);
      return;
    }
    com.tencent.e.h.ZvG.be((Runnable)b.DGP);
    AppMethodBeat.o(209684);
  }
  
  public static void eFY()
  {
    AppMethodBeat.i(209686);
    com.tencent.mm.plugin.hld.model.p localp = com.tencent.mm.plugin.hld.model.p.DEH;
    if (com.tencent.mm.plugin.hld.model.p.eFn())
    {
      AppMethodBeat.o(209686);
      return;
    }
    com.tencent.e.h.ZvG.be((Runnable)d.DGU);
    AppMethodBeat.o(209686);
  }
  
  public static void eFZ()
  {
    AppMethodBeat.i(209688);
    Object localObject = l.DHK;
    localObject = l.eHB();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_phone_contact_data_load_finish", false);
    }
    localObject = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
    ((Intent)localObject).putExtra("ime_load_contact", true);
    com.tencent.mm.by.c.l((Intent)localObject, "hld");
    AppMethodBeat.o(209688);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a$a
    implements Runnable
  {
    a$a(com.tencent.mm.ipcinvoker.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(210439);
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = i.DHq;
      if (!i.eGC())
      {
        localObject1 = b.jl(MMApplicationContext.getContext());
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList.add(((String[])localObject2.next())[1]);
        }
        Log.i("WxIme.ImeUserDictGenerator", "mobile " + ((List)localObject1).size());
      }
      localObject1 = l.DHK;
      localObject1 = l.eHB();
      if (localObject1 != null) {
        ((MultiProcessMMKV)localObject1).putInt("ime_telephone_contact_num", localArrayList.size());
      }
      localObject1 = c.DGO;
      c.eGa();
      localObject1 = c.DGO;
      localObject1 = ((Map)c.eGb()).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localArrayList.add(((Pair)((Map.Entry)localObject2).getValue()).first);
        localArrayList.add(((Pair)((Map.Entry)localObject2).getValue()).second);
      }
      localObject1 = l.DHK;
      localObject1 = l.eHB();
      if (localObject1 != null)
      {
        localObject2 = c.DGO;
        ((MultiProcessMMKV)localObject1).putInt("ime_wechat_contact_num", c.eGb().size());
      }
      localObject1 = new StringBuilder("contact ");
      Object localObject2 = c.DGO;
      Log.i("WxIme.ImeUserDictGenerator", c.eGb().size() + ' ' + localArrayList.size());
      localObject1 = new Bundle();
      ((Bundle)localObject1).putStringArrayList("contacts", localArrayList);
      this.nyL.aH(localObject1);
      AppMethodBeat.o(210439);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b DGP;
    
    static
    {
      AppMethodBeat.i(209182);
      DGP = new b();
      AppMethodBeat.o(209182);
    }
    
    public final void run()
    {
      AppMethodBeat.i(209179);
      Log.i("WxIme.ImeUserDictGenerator", "loadPhoneContactData start");
      Object localObject = l.DHK;
      if (l.biq())
      {
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCVoid(), c.a.class, (com.tencent.mm.ipcinvoker.f)1.DGQ);
        AppMethodBeat.o(209179);
        return;
      }
      localObject = com.tencent.mm.plugin.hld.model.n.DEn;
      com.tencent.mm.plugin.hld.model.n.K(new String[0]);
      localObject = f.DGX;
      f.tc(false);
      AppMethodBeat.o(209179);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "kotlin.jvm.PlatformType", "obj", "", "onNotifyChange"})
  static final class c
    implements MStorageEx.IOnStorageChange
  {
    public static final c DGS;
    
    static
    {
      AppMethodBeat.i(209404);
      DGS = new c();
      AppMethodBeat.o(209404);
    }
    
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      AppMethodBeat.i(209403);
      long l = System.currentTimeMillis();
      Object localObject = c.DGO;
      if (l - c.eGc() < 600000L)
      {
        AppMethodBeat.o(209403);
        return;
      }
      localObject = l.DHK;
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      if (!l.hi((Context)localObject))
      {
        AppMethodBeat.o(209403);
        return;
      }
      if ((paramObject == null) || (!(paramObject instanceof String)))
      {
        Log.d("WxIme.ImeUserDictGenerator", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
        AppMethodBeat.o(209403);
        return;
      }
      if (!com.tencent.mm.kernel.h.aHB())
      {
        Log.i("WxIme.ImeUserDictGenerator", "onNotifyChange acc not ready");
        AppMethodBeat.o(209403);
        return;
      }
      localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      kotlin.g.b.p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      if (paramMStorageEx == ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL()) {
        com.tencent.e.h.ZvG.d((Runnable)new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(217483);
            Object localObject1 = c.DGO;
            c.eGa();
            localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
            kotlin.g.b.p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).bbL().RG((String)this.DGT);
            Object localObject2;
            int i;
            if (localObject1 != null) {
              if (((as)localObject1).axZ())
              {
                localObject2 = c.DGO;
                String str;
                if (!((Map)c.eGb()).containsKey(this.DGT))
                {
                  localObject2 = c.DGO;
                  localObject2 = (Map)c.eGb();
                  str = ((as)localObject1).getUsername();
                  kotlin.g.b.p.j(str, "contact.username");
                  ((Map)localObject2).put(str, new Pair(((as)localObject1).getNickname(), ((as)localObject1).ays()));
                  i = 1;
                  bool = true;
                  Log.i("WxIme.ImeUserDictGenerator", "onContactChange " + this.DGT + ' ' + bool + ' ' + i + ' ' + ((as)localObject1).getUsername());
                  if (bool)
                  {
                    localObject1 = c.DGO;
                    c.Oa(System.currentTimeMillis());
                    localObject1 = c.DGO;
                    c.eFZ();
                  }
                  AppMethodBeat.o(217483);
                  return;
                }
                localObject2 = c.DGO;
                localObject2 = (Pair)c.eGb().get(((as)localObject1).getUsername());
                if (localObject2 != null)
                {
                  if ((Util.isEqual(((as)localObject1).getNickname(), (String)((Pair)localObject2).first)) && (Util.isEqual(((as)localObject1).ays(), (String)((Pair)localObject2).second))) {
                    break label401;
                  }
                  localObject2 = c.DGO;
                  localObject2 = (Map)c.eGb();
                  str = ((as)localObject1).getUsername();
                  kotlin.g.b.p.j(str, "contact.username");
                  ((Map)localObject2).put(str, new Pair(((as)localObject1).getNickname(), ((as)localObject1).ays()));
                  i = 2;
                }
              }
            }
            for (;;)
            {
              break;
              i = 0;
              bool = false;
              break;
              localObject2 = c.DGO;
              if (((Map)c.eGb()).containsKey(this.DGT))
              {
                localObject2 = c.DGO;
                c.eGb().remove(this.DGT);
                i = 3;
                bool = true;
                break;
                AppMethodBeat.o(217483);
                return;
              }
              i = 0;
              bool = false;
              break;
              label401:
              i = 0;
              bool = false;
            }
          }
        }, "WxIme.ImeUserDictGenerator");
      }
      AppMethodBeat.o(209403);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d DGU;
    
    static
    {
      AppMethodBeat.i(213380);
      DGU = new d();
      AppMethodBeat.o(213380);
    }
    
    public final void run()
    {
      AppMethodBeat.i(213375);
      Object localObject = l.DHK;
      long l2;
      if (l.biq())
      {
        l2 = cm.bfG();
        localObject = l.DHK;
        localObject = l.eHB();
        if (localObject == null) {
          break label75;
        }
      }
      label75:
      for (long l1 = ((MultiProcessMMKV)localObject).getLong("ime_phone_contact_data_load_last_time", l2);; l1 = l2)
      {
        if (l2 - l1 > 86400000L)
        {
          localObject = c.DGO;
          c.eFX();
          Log.i("WxIme.ImeUserDictGenerator", "refreshPhoneContactByDay start");
        }
        AppMethodBeat.o(213375);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.c
 * JD-Core Version:    0.7.0.1
 */