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
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.protocal.protobuf.gma;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a
  extends p
  implements m
{
  private h mAY;
  private a<a> mAZ;
  private final c rr;
  
  private a(String paramString, gma paramgma, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240875);
    Log.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dea();
    ((c.a)localObject).otF = new deb();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((c.a)localObject).funcId = 1157;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dea)c.b.b(this.rr.otB);
    if (paramInt2 > 0)
    {
      ((dea)localObject).aaJv = new glg();
      ((dea)localObject).aaJv.scene = paramInt2;
    }
    ((dea)localObject).oOI = paramString;
    ((dea)localObject).aaJs = paramLinkedList;
    ((dea)localObject).aaJu = paramInt1;
    ((dea)localObject).aaJA = paramgma;
    if (((dea)localObject).aaJA != null) {
      Log.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene req.plugin_info plugin_appid=" + ((dea)localObject).aaJA.aaWC + "  custom_version=" + ((dea)localObject).aaJA.achp + "  inner_version=" + ((dea)localObject).aaJA.achq);
    }
    AppMethodBeat.o(240875);
  }
  
  public a(String paramString, gma paramgma, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, a<a> parama)
  {
    this(paramString, paramgma, paramLinkedList, paramInt1, paramInt2);
    this.mAZ = parama;
  }
  
  public a(String paramString, LinkedList<String> paramLinkedList, a<a> parama)
  {
    this(paramString, null, paramLinkedList, 0, -1, parama);
  }
  
  public final dea aYZ()
  {
    AppMethodBeat.i(240880);
    if (this.rr == null)
    {
      AppMethodBeat.o(240880);
      return null;
    }
    dea localdea = (dea)c.b.b(this.rr.otB);
    AppMethodBeat.o(240880);
    return localdea;
  }
  
  public final deb aZa()
  {
    AppMethodBeat.i(240881);
    deb localdeb = (deb)c.c.b(this.rr.otC);
    AppMethodBeat.o(240881);
    return localdeb;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150093);
    Log.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150093);
    return i;
  }
  
  public final int getType()
  {
    return 1157;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150092);
    Log.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.mAZ != null) {
      this.mAZ.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150092);
  }
  
  public static abstract interface a<T extends p>
  {
    public abstract void onNetSceneEndCallback(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a.a
 * JD-Core Version:    0.7.0.1
 */