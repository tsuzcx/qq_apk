package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.fni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import com.tencent.mm.vfs.u;
import java.util.Locale;
import org.json.JSONObject;

public final class v
  extends StateMachine
  implements Runnable
{
  private static final String nEI;
  private final int nEJ;
  private final String nEK;
  private final State nEL;
  private final State nEM;
  private final State nEN;
  
  static
  {
    AppMethodBeat.i(281890);
    nEI = "https://" + WeChatHosts.domainString(au.i.host_res_servicewechat_com) + "/weapp/public/commlib/%d.wxapkg";
    AppMethodBeat.o(281890);
  }
  
  public v(int paramInt, String paramString)
  {
    super("LibIncrementalTestCase", Looper.getMainLooper());
    AppMethodBeat.i(44264);
    this.nEL = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44256);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
        Object localObject2 = bb.bHk();
        if (Util.isNullOrNil((String)localObject2))
        {
          v.a(v.this, "!!MockLibInfo Path Error!!");
          AppMethodBeat.o(44256);
          return;
        }
        try
        {
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("version", v.a(v.this));
          localObject2 = new com.tencent.mm.vfs.q((String)localObject2);
          ((com.tencent.mm.vfs.q)localObject2).cFq();
          ((com.tencent.mm.vfs.q)localObject2).ifM();
          localObject1 = ((JSONObject)localObject1).toString().getBytes("UTF-8");
          int i = u.f(((com.tencent.mm.vfs.q)localObject2).bOF(), (byte[])localObject1, localObject1.length);
          if (i != 0)
          {
            v.a(v.this, "MockLibInfo Write Error ".concat(String.valueOf(i)));
            AppMethodBeat.o(44256);
            return;
          }
        }
        catch (Exception localException)
        {
          v.a(v.this, "MockLibInfo Write Exception " + localException.getMessage());
          AppMethodBeat.o(44256);
          return;
        }
        v.a(v.this, v.b(v.this));
        AppMethodBeat.o(44256);
      }
    };
    this.nEM = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44259);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
        fni localfni = new fni();
        localfni.url = String.format(Locale.US, v.nEI, new Object[] { Integer.valueOf(v.a(v.this)) });
        localfni.version = v.a(v.this);
        localfni.md5 = v.c(v.this);
        localfni.TWD = 1;
        m.bFP().a(localfni, new PInt());
        bq.a(localfni.url, localfni.version, new bq.a() {});
        AppMethodBeat.o(44259);
      }
    };
    this.nEN = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44262);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
        aw.hs(true);
        h.aHF().kcd.a(1168, new i()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.q paramAnonymous2q)
          {
            AppMethodBeat.i(44261);
            if ((paramAnonymous2q != null) && ((paramAnonymous2q.getReqResp() instanceof d)))
            {
              paramAnonymous2String = (fni)d.c.b(((d)paramAnonymous2q.getReqResp()).lBS);
              paramAnonymous2Int1 = v.a(v.this);
              paramAnonymous2Int2 = paramAnonymous2String.version;
              paramAnonymous2String = new bq.a() {};
              bq.a(az.B("@LibraryAppId", paramAnonymous2Int1, paramAnonymous2Int2), paramAnonymous2String);
            }
            h.aHF().kcd.b(1168, this);
            AppMethodBeat.o(44261);
          }
        });
        AppMethodBeat.o(44262);
      }
    };
    this.nEJ = paramInt;
    this.nEK = paramString;
    AppMethodBeat.o(44264);
  }
  
  public final void onQuitting()
  {
    AppMethodBeat.i(44266);
    super.onQuitting();
    Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
    AppMethodBeat.o(44266);
  }
  
  public final void run()
  {
    AppMethodBeat.i(44265);
    addState(this.nEL);
    addState(this.nEM);
    addState(this.nEN);
    setInitialState(this.nEL);
    start();
    AppMethodBeat.o(44265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */