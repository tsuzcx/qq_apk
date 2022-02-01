package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.gkb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Locale;
import org.json.JSONObject;

public final class x
  extends StateMachine
  implements Runnable
{
  private static final String qEF;
  private final int qEG;
  private final String qEH;
  private final State qEI;
  private final State qEJ;
  private final State qEK;
  
  static
  {
    AppMethodBeat.i(320332);
    qEF = "https://" + WeChatHosts.domainString(ba.i.host_res_servicewechat_com) + "/weapp/public/commlib/%d.wxapkg";
    AppMethodBeat.o(320332);
  }
  
  public x(int paramInt, String paramString)
  {
    super("LibIncrementalTestCase", Looper.getMainLooper());
    AppMethodBeat.i(44264);
    this.qEI = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44256);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
        Object localObject2 = bc.cgH();
        if (Util.isNullOrNil((String)localObject2))
        {
          x.a(x.this, "!!MockLibInfo Path Error!!");
          AppMethodBeat.o(44256);
          return;
        }
        try
        {
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("version", x.a(x.this));
          localObject2 = new u((String)localObject2);
          ((u)localObject2).diJ();
          ((u)localObject2).jKZ();
          localObject1 = ((JSONObject)localObject1).toString().getBytes("UTF-8");
          int i = y.f(ah.v(((u)localObject2).jKT()), (byte[])localObject1, localObject1.length);
          if (i != 0)
          {
            x.a(x.this, "MockLibInfo Write Error ".concat(String.valueOf(i)));
            AppMethodBeat.o(44256);
            return;
          }
        }
        catch (Exception localException)
        {
          x.a(x.this, "MockLibInfo Write Exception " + localException.getMessage());
          AppMethodBeat.o(44256);
          return;
        }
        x.a(x.this, x.b(x.this));
        AppMethodBeat.o(44256);
      }
    };
    this.qEJ = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44259);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
        gkb localgkb = new gkb();
        localgkb.url = String.format(Locale.US, x.qEF, new Object[] { Integer.valueOf(x.a(x.this)) });
        localgkb.version = x.a(x.this);
        localgkb.md5 = x.c(x.this);
        localgkb.abns = 1;
        n.cfm().a(localgkb, new PInt());
        bq.a(localgkb.url, localgkb.version, new bq.a() {});
        AppMethodBeat.o(44259);
      }
    };
    this.qEK = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(44262);
        super.enter();
        Log.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
        ax.ij(true);
        com.tencent.mm.kernel.h.baD().mCm.a(1168, new com.tencent.mm.am.h()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
          {
            AppMethodBeat.i(44261);
            if ((paramAnonymous2p != null) && ((paramAnonymous2p.getReqResp() instanceof com.tencent.mm.am.c)))
            {
              paramAnonymous2String = (gkb)c.c.b(((com.tencent.mm.am.c)paramAnonymous2p.getReqResp()).otC);
              paramAnonymous2Int1 = x.a(x.this);
              paramAnonymous2Int2 = paramAnonymous2String.version;
              paramAnonymous2String = new bq.a() {};
              bq.a(ba.F("@LibraryAppId", paramAnonymous2Int1, paramAnonymous2Int2), paramAnonymous2String);
            }
            com.tencent.mm.kernel.h.baD().mCm.b(1168, this);
            AppMethodBeat.o(44261);
          }
        });
        AppMethodBeat.o(44262);
      }
    };
    this.qEG = paramInt;
    this.qEH = paramString;
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
    addState(this.qEI);
    addState(this.qEJ);
    addState(this.qEK);
    setInitialState(this.qEI);
    start();
    AppMethodBeat.o(44265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x
 * JD-Core Version:    0.7.0.1
 */