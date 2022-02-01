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
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends p
  implements m
{
  private h mAY;
  private a<b> mBa;
  public final c rr;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150094);
    Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ddy();
    ((c.a)localObject).otF = new ddz();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((c.a)localObject).funcId = 1158;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ddy)c.b.b(this.rr.otB);
    if (paramInt3 > 0)
    {
      ((ddy)localObject).aaJv = new glg();
      ((ddy)localObject).aaJv.scene = paramInt3;
    }
    ((ddy)localObject).oOI = paramString;
    ((ddy)localObject).aaJs = paramLinkedList;
    ((ddy)localObject).aaJu = paramInt1;
    ((ddy)localObject).aaJt = paramInt2;
    AppMethodBeat.o(150094);
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.mBa = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final ddy aZb()
  {
    AppMethodBeat.i(240874);
    if (this.rr == null)
    {
      AppMethodBeat.o(240874);
      return null;
    }
    ddy localddy = (ddy)c.b.b(this.rr.otB);
    AppMethodBeat.o(240874);
    return localddy;
  }
  
  public final ddz aZc()
  {
    AppMethodBeat.i(240876);
    ddz localddz = (ddz)c.c.b(this.rr.otC);
    AppMethodBeat.o(240876);
    return localddz;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150096);
    Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150096);
    return i;
  }
  
  public final int getType()
  {
    return 1158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150095);
    Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.mBa != null) {
      this.mBa.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150095);
  }
  
  public static abstract interface a<T extends p>
  {
    public abstract void onNetSceneEndCallback(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a.b
 * JD-Core Version:    0.7.0.1
 */