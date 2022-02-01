package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class e
{
  LinkedList<abj> nBs;
  String nBt;
  private String nBu;
  private boolean nBv;
  a nBw;
  private aw nBx;
  final f nBy;
  final f nBz;
  com.tencent.mm.plugin.backup.b.e nxZ;
  
  public e(a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    AppMethodBeat.i(21363);
    this.nBu = "";
    this.nBv = false;
    this.nBx = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21360);
        e.this.bIW();
        AppMethodBeat.o(21360);
        return true;
      }
    }, true);
    this.nBy = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21361);
        com.tencent.mm.plugin.backup.g.b.b(704, e.this.nBy);
        ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (paramAnonymousInt2 == -100)
          {
            bc.ajj().a(1000, e.this.nBz);
            paramAnonymousString = new com.tencent.mm.plugin.backup.e.a(e.this.nBs, e.this.nBt, b.bIE().nAs);
            bc.ajj().a(paramAnonymousString, 0);
            AppMethodBeat.o(21361);
            return;
          }
          e.this.nxZ.nye = -11;
          e.this.nBw.n(-11, null);
          AppMethodBeat.o(21361);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.e.b)paramAnonymousn;
        paramAnonymousn = (ie)paramAnonymousString.rr.hQE.hQJ;
        b.bIE().nxW = "";
        b.bIE().nxX = paramAnonymousn.FTc;
        b.bIE().nxY = paramAnonymousn.FTd;
        b.bIE().nAs = paramAnonymousn.FSY;
        paramAnonymousString = (ie)paramAnonymousString.rr.hQE.hQJ;
        if (paramAnonymousString == null) {
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.this.nxZ.nye = 51;
            e.this.nBw.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21361);
          return;
          if (paramAnonymousString.FSZ == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousString.FSZ.getBufferToBytes();
          }
        }
      }
    };
    this.nBz = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21362);
        com.tencent.mm.plugin.backup.g.b.b(1000, e.this.nBz);
        ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          e.this.nxZ.nye = -11;
          e.this.nBw.n(-11, null);
          AppMethodBeat.o(21362);
          return;
        }
        paramAnonymousn = ((k.b)((com.tencent.mm.plugin.backup.e.a)paramAnonymousn).hRG.getRespObj()).FGu;
        if (paramAnonymousn == null)
        {
          paramAnonymousString = "null";
          ae.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramAnonymousString });
          if (paramAnonymousn != null) {
            break label202;
          }
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.this.nxZ.nye = 51;
            e.this.nBw.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21362);
          return;
          paramAnonymousString = paramAnonymousn.FTa;
          break;
          label202:
          if (paramAnonymousn.FSZ == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousn.FSZ.getBufferToBytes();
          }
        }
      }
    };
    this.nBw = parama;
    this.nxZ = parame;
    AppMethodBeat.o(21363);
  }
  
  private boolean bIX()
  {
    AppMethodBeat.i(21367);
    this.nBs = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.nBt = g.el(ak.getContext());
    ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.nBt });
    if (bu.isNullOrNil(this.nBt))
    {
      this.nxZ.nye = -4;
      this.nBw.n(-4, null);
      this.nBu = "";
      AppMethodBeat.o(21367);
      return false;
    }
    if (!b.bIE().bIF().a(localPString, localPInt))
    {
      this.nxZ.nye = -4;
      this.nBw.n(-4, null);
      this.nBu = "";
      AppMethodBeat.o(21367);
      return false;
    }
    ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    abj localabj = new abj();
    localabj.Gpn = localPString.value;
    localabj.Gtd = new LinkedList();
    localabj.Gtd.add(Integer.valueOf(localPInt.value));
    this.nBs.add(localabj);
    AppMethodBeat.o(21367);
    return true;
  }
  
  final void bIW()
  {
    AppMethodBeat.i(21366);
    Object localObject = g.el(ak.getContext());
    ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[] { localObject, this.nBu, Boolean.valueOf(bc.ajM()), Boolean.valueOf(bc.aiT()) });
    if (!((String)localObject).equals(this.nBu))
    {
      if (!bc.ajM())
      {
        AppMethodBeat.o(21366);
        return;
      }
      this.nBu = ((String)localObject);
      if (!bIX())
      {
        this.nBv = false;
        AppMethodBeat.o(21366);
        return;
      }
      this.nBv = false;
      if (!bc.aiT())
      {
        ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
        bc.ajj().a(704, this.nBy);
        localObject = new com.tencent.mm.plugin.backup.e.b(this.nBs, this.nBt);
        bc.ajj().a((n)localObject, 0);
        AppMethodBeat.o(21366);
        return;
      }
      ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
      bc.ajj().a(1000, this.nBz);
      localObject = new com.tencent.mm.plugin.backup.e.a(this.nBs, this.nBt, b.bIE().nAs);
      bc.ajj().a((n)localObject, 0);
    }
    AppMethodBeat.o(21366);
  }
  
  public final void start()
  {
    AppMethodBeat.i(21364);
    ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.nBv), Boolean.valueOf(this.nBx.foU()), this, bu.fpN() });
    if (this.nBv)
    {
      AppMethodBeat.o(21364);
      return;
    }
    this.nBv = true;
    if (bIX())
    {
      this.nBu = null;
      bIW();
    }
    for (;;)
    {
      this.nBx.ay(500L, 500L);
      AppMethodBeat.o(21364);
      return;
      this.nxZ.nye = -4;
      this.nBw.n(-4, null);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21365);
    ae.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.nBv = false;
    bc.ajj().b(704, this.nBy);
    bc.ajj().b(1000, this.nBz);
    this.nBx.stopTimer();
    AppMethodBeat.o(21365);
  }
  
  public static abstract interface a
  {
    public abstract void n(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e
 * JD-Core Version:    0.7.0.1
 */