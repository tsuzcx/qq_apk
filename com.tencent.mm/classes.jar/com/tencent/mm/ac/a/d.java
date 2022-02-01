package com.tencent.mm.ac.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends p
  implements m
{
  private h mAY;
  private a<d> mBc;
  private final c rr;
  
  private d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150100);
    Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dec();
    ((c.a)localObject).otF = new ded();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
    ((c.a)localObject).funcId = 1117;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dec)c.b.b(this.rr.otB);
    if (paramInt4 > 0)
    {
      ((dec)localObject).aaJv = new glg();
      ((dec)localObject).aaJv.scene = paramInt4;
    }
    ((dec)localObject).oOI = paramString1;
    ((dec)localObject).aaJs = paramLinkedList;
    ((dec)localObject).aaJG = paramInt1;
    ((dec)localObject).aaJH = paramString2;
    ((dec)localObject).aaJu = paramInt2;
    ((dec)localObject).aaJt = paramInt3;
    AppMethodBeat.o(150100);
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, a<d> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramInt2, paramInt3, paramInt4);
    this.mBc = parama;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, String paramString2, int paramInt, a<d> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, 0, paramInt, -1, parama);
  }
  
  public final dec aZf()
  {
    AppMethodBeat.i(240877);
    if (this.rr == null)
    {
      AppMethodBeat.o(240877);
      return null;
    }
    dec localdec = (dec)c.b.b(this.rr.otB);
    AppMethodBeat.o(240877);
    return localdec;
  }
  
  public final ded aZg()
  {
    AppMethodBeat.i(240878);
    ded localded = (ded)c.c.b(this.rr.otC);
    AppMethodBeat.o(240878);
    return localded;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150102);
    Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150102);
    return i;
  }
  
  public final int getType()
  {
    return 1117;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150101);
    Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.mBc != null) {
      this.mBc.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150101);
  }
  
  public static abstract interface a<T extends p>
  {
    public abstract void onNetSceneEndCallback(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a.d
 * JD-Core Version:    0.7.0.1
 */