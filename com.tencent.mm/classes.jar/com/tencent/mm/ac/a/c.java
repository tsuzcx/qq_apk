package com.tencent.mm.ac.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c
  extends p
  implements m
{
  private h mAY;
  private a<c> mBb;
  private final com.tencent.mm.am.c rr;
  
  private c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150097);
    Log.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = new dee();
    ((com.tencent.mm.am.c.a)localObject).otF = new def();
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-login";
    ((com.tencent.mm.am.c.a)localObject).funcId = 1029;
    ((com.tencent.mm.am.c.a)localObject).otG = 0;
    ((com.tencent.mm.am.c.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.am.c.a)localObject).bEF();
    localObject = (dee)c.b.b(this.rr.otB);
    ((dee)localObject).oOI = paramString1;
    ((dee)localObject).aaJs = paramLinkedList;
    ((dee)localObject).aaJG = paramInt1;
    ((dee)localObject).Url = paramString2;
    ((dee)localObject).aaJH = paramString3;
    ((dee)localObject).aaJu = paramInt2;
    if (paramInt3 > 0)
    {
      ((dee)localObject).aaJv = new glg();
      ((dee)localObject).aaJv.scene = paramInt3;
    }
    AppMethodBeat.o(150097);
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, a<c> parama)
  {
    this(paramString1, paramLinkedList, paramInt1, paramString2, paramString3, paramInt2, paramInt3);
    this.mBb = parama;
  }
  
  public c(String paramString1, LinkedList<String> paramLinkedList, String paramString2, String paramString3, a<c> parama)
  {
    this(paramString1, paramLinkedList, 0, paramString2, paramString3, 0, -1, parama);
  }
  
  public final dee aZd()
  {
    AppMethodBeat.i(240872);
    if (this.rr == null)
    {
      AppMethodBeat.o(240872);
      return null;
    }
    dee localdee = (dee)c.b.b(this.rr.otB);
    AppMethodBeat.o(240872);
    return localdee;
  }
  
  public final def aZe()
  {
    AppMethodBeat.i(240873);
    def localdef = (def)c.c.b(this.rr.otC);
    AppMethodBeat.o(240873);
    return localdef;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150099);
    Log.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150099);
    return i;
  }
  
  public final int getType()
  {
    return 1029;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150098);
    Log.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.mBb != null) {
      this.mBb.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150098);
  }
  
  public static abstract interface a<T extends p>
  {
    public abstract void onNetSceneEndCallback(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a.c
 * JD-Core Version:    0.7.0.1
 */