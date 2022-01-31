package com.tencent.mm.ai;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class w
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  public String egK;
  public int egL = 1;
  public String tag;
  
  public w(String paramString, LinkedList<String> paramLinkedList)
  {
    this(paramString, paramLinkedList, (byte)0);
  }
  
  private w(String paramString, LinkedList<String> paramLinkedList, byte paramByte)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new asq();
    ((b.a)localObject).ecI = new asr();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
    ((b.a)localObject).ecG = 675;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (asq)this.dmK.ecE.ecN;
    ((asq)localObject).toq = paramString;
    ((asq)localObject).tot = paramLinkedList;
    this.egK = paramString;
    this.egL = 1;
  }
  
  public final asr Mv()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (asr)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 675;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.w
 * JD-Core Version:    0.7.0.1
 */