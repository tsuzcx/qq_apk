package com.tencent.mm.ac.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends q
  implements m
{
  private i jQg;
  private a<d> kaX;
  private final com.tencent.mm.an.d rr;
  
  private d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150100);
    Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject).lBU = new cnk();
    ((com.tencent.mm.an.d.a)localObject).lBV = new cnl();
    ((com.tencent.mm.an.d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
    ((com.tencent.mm.an.d.a)localObject).funcId = 1117;
    ((com.tencent.mm.an.d.a)localObject).lBW = 0;
    ((com.tencent.mm.an.d.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.an.d.a)localObject).bgN();
    localObject = (cnk)d.b.b(this.rr.lBR);
    if (paramInt4 > 0)
    {
      ((cnk)localObject).TuQ = new foh();
      ((cnk)localObject).TuQ.scene = paramInt4;
    }
    ((cnk)localObject).lVG = paramString1;
    ((cnk)localObject).TuN = paramLinkedList;
    ((cnk)localObject).Tva = paramInt1;
    ((cnk)localObject).Tvb = paramString2;
    ((cnk)localObject).TuP = paramInt2;
    ((cnk)localObject).TuO = paramInt3;
    AppMethodBeat.o(150100);
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, a<d> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramInt2, paramInt3, paramInt4);
    this.kaX = parama;
  }
  
  public d(String paramString1, LinkedList<String> paramLinkedList, String paramString2, int paramInt, a<d> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, 0, paramInt, -1, parama);
  }
  
  public final cnk aGg()
  {
    AppMethodBeat.i(187346);
    if (this.rr == null)
    {
      AppMethodBeat.o(187346);
      return null;
    }
    cnk localcnk = (cnk)d.b.b(this.rr.lBR);
    AppMethodBeat.o(187346);
    return localcnk;
  }
  
  public final cnl aGh()
  {
    AppMethodBeat.i(187347);
    cnl localcnl = (cnl)d.c.b(this.rr.lBS);
    AppMethodBeat.o(187347);
    return localcnl;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150102);
    Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
    this.jQg = parami;
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
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.kaX != null) {
      this.kaX.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150101);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a.d
 * JD-Core Version:    0.7.0.1
 */