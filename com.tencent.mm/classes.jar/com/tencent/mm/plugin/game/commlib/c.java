package com.tencent.mm.plugin.game.commlib;

import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  private final com.tencent.mm.ak.b gux;
  
  public c()
  {
    AppMethodBeat.i(89934);
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).hQF = new bh();
    ((com.tencent.mm.ak.b.a)localObject).hQG = new bi();
    ((com.tencent.mm.ak.b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
    ((com.tencent.mm.ak.b.a)localObject).funcId = getType();
    ((com.tencent.mm.ak.b.a)localObject).hQH = 0;
    ((com.tencent.mm.ak.b.a)localObject).respCmdId = 0;
    this.gux = ((com.tencent.mm.ak.b.a)localObject).aDS();
    bh localbh = (bh)this.gux.hQD.hQJ;
    localbh.usS = ad.fom();
    String str = com.tencent.mm.plugin.game.api.b.a.cZq().cZg();
    localObject = str;
    if (bu.isNullOrNil(str)) {
      localObject = bu.jm(ak.getContext());
    }
    localbh.jge = ((String)localObject);
    localbh.usT = com.tencent.mm.sdk.platformtools.k.cSM;
    localbh.usU = new com.tencent.mm.plugin.game.d.f();
    localbh.usU.uqo = Build.VERSION.SDK_INT;
    localbh.usU.uqp = YearClass.get(ak.getContext());
    ae.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", new Object[] { localbh.usS, localbh.jge, Integer.valueOf(localbh.usT), Integer.valueOf(localbh.usU.uqo), Integer.valueOf(localbh.usU.uqp) });
    AppMethodBeat.o(89934);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(89936);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
    AppMethodBeat.o(89936);
    return i;
  }
  
  public final int getType()
  {
    return 1311;
  }
  
  /* Error */
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 180
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 147
    //   7: new 182	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 184
    //   13: invokespecial 187	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_2
    //   17: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc 193
    //   22: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_3
    //   26: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc 198
    //   31: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 4
    //   36: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 204	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iload_2
    //   46: ifne +7 -> 53
    //   49: iload_3
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: getfield 171	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/ak/f;
    //   57: iload_2
    //   58: iload_3
    //   59: aload 4
    //   61: aload_0
    //   62: invokeinterface 210 5 0
    //   67: ldc 180
    //   69: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: aload 5
    //   75: checkcast 65	com/tencent/mm/ak/b
    //   78: getfield 214	com/tencent/mm/ak/b:hQE	Lcom/tencent/mm/ak/b$c;
    //   81: getfield 217	com/tencent/mm/ak/b$c:hQJ	Lcom/tencent/mm/bw/a;
    //   84: checkcast 33	com/tencent/mm/plugin/game/d/bi
    //   87: astore 5
    //   89: aload 5
    //   91: ifnonnull +23 -> 114
    //   94: aload_0
    //   95: getfield 171	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/ak/f;
    //   98: iload_2
    //   99: iload_3
    //   100: aload 4
    //   102: aload_0
    //   103: invokeinterface 210 5 0
    //   108: ldc 180
    //   110: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: ldc 219
    //   116: invokestatic 225	com/tencent/mm/sdk/platformtools/ay:aRW	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ay;
    //   119: astore 6
    //   121: aload 6
    //   123: ifnull +13 -> 136
    //   126: aload 6
    //   128: ldc 227
    //   130: ldc 229
    //   132: invokevirtual 233	com/tencent/mm/sdk/platformtools/ay:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: pop
    //   136: aload 5
    //   138: putstatic 239	com/tencent/mm/plugin/game/commlib/a:udz	Lcom/tencent/mm/plugin/game/d/bi;
    //   141: aload 5
    //   143: getfield 243	com/tencent/mm/plugin/game/d/bi:utd	Lcom/tencent/mm/plugin/game/d/y;
    //   146: ifnull +27 -> 173
    //   149: invokestatic 249	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   152: invokevirtual 255	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   155: getstatic 261	com/tencent/mm/storage/am$a:IYT	Lcom/tencent/mm/storage/am$a;
    //   158: getstatic 239	com/tencent/mm/plugin/game/commlib/a:udz	Lcom/tencent/mm/plugin/game/d/bi;
    //   161: getfield 243	com/tencent/mm/plugin/game/d/bi:utd	Lcom/tencent/mm/plugin/game/d/y;
    //   164: getfield 267	com/tencent/mm/plugin/game/d/y:urD	Z
    //   167: invokestatic 272	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   170: invokevirtual 278	com/tencent/mm/storage/aj:set	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)V
    //   173: new 280	com/tencent/mm/vfs/k
    //   176: dup
    //   177: invokestatic 285	com/tencent/mm/plugin/game/commlib/util/b:cZG	()Ljava/lang/String;
    //   180: invokespecial 286	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   183: astore 6
    //   185: aload 6
    //   187: invokevirtual 290	com/tencent/mm/vfs/k:exists	()Z
    //   190: ifeq +11 -> 201
    //   193: aload 6
    //   195: invokevirtual 293	com/tencent/mm/vfs/k:isDirectory	()Z
    //   198: ifne +9 -> 207
    //   201: aload 6
    //   203: invokevirtual 296	com/tencent/mm/vfs/k:mkdirs	()Z
    //   206: pop
    //   207: aload 5
    //   209: invokevirtual 300	com/tencent/mm/plugin/game/d/bi:toByteArray	()[B
    //   212: astore 6
    //   214: new 302	com/tencent/mm/vfs/p
    //   217: dup
    //   218: invokestatic 305	com/tencent/mm/plugin/game/commlib/a:cZr	()Ljava/lang/String;
    //   221: invokespecial 306	com/tencent/mm/vfs/p:<init>	(Ljava/lang/String;)V
    //   224: astore 5
    //   226: aload 5
    //   228: aload 6
    //   230: invokevirtual 310	com/tencent/mm/vfs/p:write	([B)V
    //   233: aload 5
    //   235: ifnull +8 -> 243
    //   238: aload 5
    //   240: invokevirtual 313	com/tencent/mm/vfs/p:close	()V
    //   243: invokestatic 318	com/tencent/mm/plugin/game/commlib/e:cZD	()V
    //   246: invokestatic 323	com/tencent/mm/plugin/game/commlib/d/a:cGJ	()V
    //   249: aload_0
    //   250: getfield 171	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/ak/f;
    //   253: iload_2
    //   254: iload_3
    //   255: aload 4
    //   257: aload_0
    //   258: invokeinterface 210 5 0
    //   263: ldc 180
    //   265: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: return
    //   269: astore 6
    //   271: aconst_null
    //   272: astore 5
    //   274: ldc_w 325
    //   277: new 182	java/lang/StringBuilder
    //   280: dup
    //   281: ldc_w 327
    //   284: invokespecial 187	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: aload 6
    //   289: invokevirtual 330	java/io/IOException:getMessage	()Ljava/lang/String;
    //   292: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 333	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: goto -68 -> 233
    //   304: astore 5
    //   306: goto -63 -> 243
    //   309: astore 6
    //   311: goto -37 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	c
    //   0	314	1	paramInt1	int
    //   0	314	2	paramInt2	int
    //   0	314	3	paramInt3	int
    //   0	314	4	paramString	String
    //   0	314	5	paramq	com.tencent.mm.network.q
    //   0	314	6	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   207	226	269	java/io/IOException
    //   238	243	304	java/io/IOException
    //   226	233	309	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.c
 * JD-Core Version:    0.7.0.1
 */