package com.tencent.mm.plugin.game.commlib;

import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;

public final class c
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b grW;
  
  public c()
  {
    AppMethodBeat.i(89934);
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).hNM = new ba();
    ((com.tencent.mm.al.b.a)localObject).hNN = new bb();
    ((com.tencent.mm.al.b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
    ((com.tencent.mm.al.b.a)localObject).funcId = getType();
    ((com.tencent.mm.al.b.a)localObject).hNO = 0;
    ((com.tencent.mm.al.b.a)localObject).respCmdId = 0;
    this.grW = ((com.tencent.mm.al.b.a)localObject).aDC();
    ba localba = (ba)this.grW.hNK.hNQ;
    localba.uhu = ac.fks();
    String str = com.tencent.mm.plugin.game.api.b.a.cWM().cWB();
    localObject = str;
    if (bt.isNullOrNil(str)) {
      localObject = bt.jg(aj.getContext());
    }
    localba.jdl = ((String)localObject);
    localba.uhv = j.cSc;
    localba.uhw = new com.tencent.mm.plugin.game.d.e();
    localba.uhw.ufe = Build.VERSION.SDK_INT;
    localba.uhw.uff = YearClass.get(aj.getContext());
    ad.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", new Object[] { localba.uhu, localba.jdl, Integer.valueOf(localba.uhv), Integer.valueOf(localba.uhw.ufe), Integer.valueOf(localba.uhw.uff) });
    AppMethodBeat.o(89934);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(89936);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
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
    //   42: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iload_2
    //   46: ifne +7 -> 53
    //   49: iload_3
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: getfield 171	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/al/f;
    //   57: iload_2
    //   58: iload_3
    //   59: aload 4
    //   61: aload_0
    //   62: invokeinterface 210 5 0
    //   67: ldc 180
    //   69: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: aload 5
    //   75: checkcast 65	com/tencent/mm/al/b
    //   78: getfield 214	com/tencent/mm/al/b:hNL	Lcom/tencent/mm/al/b$c;
    //   81: getfield 217	com/tencent/mm/al/b$c:hNQ	Lcom/tencent/mm/bx/a;
    //   84: checkcast 33	com/tencent/mm/plugin/game/d/bb
    //   87: astore 5
    //   89: aload 5
    //   91: ifnonnull +23 -> 114
    //   94: aload_0
    //   95: getfield 171	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/al/f;
    //   98: iload_2
    //   99: iload_3
    //   100: aload 4
    //   102: aload_0
    //   103: invokeinterface 210 5 0
    //   108: ldc 180
    //   110: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: ldc 219
    //   116: invokestatic 225	com/tencent/mm/sdk/platformtools/ax:aQz	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   119: astore 6
    //   121: aload 6
    //   123: ifnull +13 -> 136
    //   126: aload 6
    //   128: ldc 227
    //   130: ldc 229
    //   132: invokevirtual 233	com/tencent/mm/sdk/platformtools/ax:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: pop
    //   136: aload 5
    //   138: putstatic 239	com/tencent/mm/plugin/game/commlib/a:tSI	Lcom/tencent/mm/plugin/game/d/bb;
    //   141: aload 5
    //   143: getfield 243	com/tencent/mm/plugin/game/d/bb:uhF	Lcom/tencent/mm/plugin/game/d/u;
    //   146: ifnull +27 -> 173
    //   149: invokestatic 249	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   152: invokevirtual 255	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   155: getstatic 261	com/tencent/mm/storage/al$a:IEt	Lcom/tencent/mm/storage/al$a;
    //   158: getstatic 239	com/tencent/mm/plugin/game/commlib/a:tSI	Lcom/tencent/mm/plugin/game/d/bb;
    //   161: getfield 243	com/tencent/mm/plugin/game/d/bb:uhF	Lcom/tencent/mm/plugin/game/d/u;
    //   164: getfield 267	com/tencent/mm/plugin/game/d/u:ugg	Z
    //   167: invokestatic 272	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   170: invokevirtual 278	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   173: new 280	com/tencent/mm/vfs/e
    //   176: dup
    //   177: invokestatic 285	com/tencent/mm/plugin/game/commlib/util/b:cWZ	()Ljava/lang/String;
    //   180: invokespecial 286	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   183: astore 6
    //   185: aload 6
    //   187: invokevirtual 290	com/tencent/mm/vfs/e:exists	()Z
    //   190: ifeq +11 -> 201
    //   193: aload 6
    //   195: invokevirtual 293	com/tencent/mm/vfs/e:isDirectory	()Z
    //   198: ifne +9 -> 207
    //   201: aload 6
    //   203: invokevirtual 296	com/tencent/mm/vfs/e:mkdirs	()Z
    //   206: pop
    //   207: aload 5
    //   209: invokevirtual 300	com/tencent/mm/plugin/game/d/bb:toByteArray	()[B
    //   212: astore 6
    //   214: new 302	com/tencent/mm/vfs/j
    //   217: dup
    //   218: invokestatic 305	com/tencent/mm/plugin/game/commlib/a:cWN	()Ljava/lang/String;
    //   221: invokespecial 306	com/tencent/mm/vfs/j:<init>	(Ljava/lang/String;)V
    //   224: astore 5
    //   226: aload 5
    //   228: aload 6
    //   230: invokevirtual 310	com/tencent/mm/vfs/j:write	([B)V
    //   233: aload 5
    //   235: ifnull +8 -> 243
    //   238: aload 5
    //   240: invokevirtual 313	com/tencent/mm/vfs/j:close	()V
    //   243: invokestatic 318	com/tencent/mm/plugin/game/commlib/e:cWW	()V
    //   246: invokestatic 323	com/tencent/mm/plugin/game/commlib/d/a:cEN	()V
    //   249: aload_0
    //   250: getfield 171	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/al/f;
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
    //   298: invokestatic 333	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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