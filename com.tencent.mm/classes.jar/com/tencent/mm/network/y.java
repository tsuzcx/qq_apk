package com.tencent.mm.network;

import com.tencent.mm.a.n;
import com.tencent.mm.sdk.platformtools.bk;

public final class y
{
  private static final byte[] eOE = n.eg(7);
  public m eOF;
  
  public final void onPush(int paramInt, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("onNotify, datalen=");
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", i + " cmd= " + paramInt);
    }
    switch (paramInt)
    {
    case 11: 
    case 12: 
    default: 
    case 5: 
    case 24: 
    case 2147480001: 
    case 39: 
    case 61: 
    case 8: 
    case 120: 
    case 122: 
      do
      {
        do
        {
          do
          {
            return;
            i = paramArrayOfByte.length;
            break;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
            this.eOF.e(138, eOE);
            return;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", new Object[] { bk.bD(paramArrayOfByte) });
            this.eOF.e(138, paramArrayOfByte);
            return;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush GCM notify [%s]", new Object[] { bk.bD(paramArrayOfByte) });
            this.eOF.e(2147480001, paramArrayOfByte);
            return;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
            this.eOF.e(39, null);
            return;
            this.eOF.e(174, paramArrayOfByte);
            return;
          } while (paramArrayOfByte.length <= 0);
          this.eOF.e(10, paramArrayOfByte);
          return;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
        } while (paramArrayOfByte.length <= 0);
        this.eOF.e(120, paramArrayOfByte);
        return;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
      } while (paramArrayOfByte.length <= 0);
      this.eOF.e(268369921, paramArrayOfByte);
      return;
    case 1000000205: 
      this.eOF.e(1000000205, paramArrayOfByte);
      return;
    case 192: 
      this.eOF.e(192, paramArrayOfByte);
      return;
    case 268369923: 
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
      this.eOF.e(268369923, paramArrayOfByte);
      return;
    case 241: 
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
      this.eOF.e(241, paramArrayOfByte);
      return;
    case 244: 
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
      this.eOF.e(244, paramArrayOfByte);
      return;
    case 319: 
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
      this.eOF.e(319, paramArrayOfByte);
      return;
    case 311: 
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
      this.eOF.e(311, paramArrayOfByte);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
    this.eOF.e(318, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.network.y
 * JD-Core Version:    0.7.0.1
 */