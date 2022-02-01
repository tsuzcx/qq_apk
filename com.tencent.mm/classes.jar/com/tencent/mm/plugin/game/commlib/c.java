package com.tencent.mm.plugin.game.commlib;

import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.bi;
import com.tencent.mm.plugin.game.protobuf.f;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends q
  implements m
{
  private i callback;
  private final d hhm;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(201264);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bi();
    ((d.a)localObject).iLO = new GetGameCenterGlobalSettingResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    bi localbi = (bi)this.hhm.iLK.iLR;
    localbi.xLl = LocaleUtil.getApplicationLanguage();
    String str = b.a.dSQ().dSF();
    localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = Util.getSimCountryCode(MMApplicationContext.getContext());
    }
    localbi.keh = ((String)localObject);
    localbi.xLm = ChannelUtil.channelId;
    localbi.xLn = new f();
    localbi.xLn.xIH = Build.VERSION.SDK_INT;
    localbi.xLn.xII = YearClass.get(MMApplicationContext.getContext());
    localbi.Scene = paramInt;
    Log.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d, scene:%d", new Object[] { localbi.xLl, localbi.keh, Integer.valueOf(localbi.xLm), Integer.valueOf(localbi.xLn.xIH), Integer.valueOf(localbi.xLn.xII), Integer.valueOf(paramInt) });
    AppMethodBeat.o(201264);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(89936);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
    AppMethodBeat.o(89936);
    return i;
  }
  
  public final int getType()
  {
    return 1311;
  }
  
  /* Error */
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 183
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 150
    //   7: new 185	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 187
    //   13: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_2
    //   17: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc 196
    //   22: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_3
    //   26: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc 201
    //   31: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 4
    //   36: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iload_2
    //   46: ifne +7 -> 53
    //   49: iload_3
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: getfield 174	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/ak/i;
    //   57: iload_2
    //   58: iload_3
    //   59: aload 4
    //   61: aload_0
    //   62: invokeinterface 213 5 0
    //   67: ldc 183
    //   69: invokestatic 168	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: aload 5
    //   75: checkcast 65	com/tencent/mm/ak/d
    //   78: getfield 217	com/tencent/mm/ak/d:iLL	Lcom/tencent/mm/ak/d$c;
    //   81: getfield 220	com/tencent/mm/ak/d$c:iLR	Lcom/tencent/mm/bw/a;
    //   84: checkcast 33	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse
    //   87: astore 5
    //   89: aload 5
    //   91: ifnonnull +23 -> 114
    //   94: aload_0
    //   95: getfield 174	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/ak/i;
    //   98: iload_2
    //   99: iload_3
    //   100: aload 4
    //   102: aload_0
    //   103: invokeinterface 213 5 0
    //   108: ldc 183
    //   110: invokestatic 168	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: ldc 222
    //   116: invokestatic 228	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   119: astore 6
    //   121: aload 6
    //   123: ifnull +13 -> 136
    //   126: aload 6
    //   128: ldc 230
    //   130: ldc 232
    //   132: invokevirtual 236	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: pop
    //   136: ldc 150
    //   138: ldc 238
    //   140: iconst_1
    //   141: anewarray 154	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload 5
    //   148: invokestatic 244	com/tencent/mm/ac/g:bN	(Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: aastore
    //   152: invokestatic 165	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload 5
    //   157: putstatic 250	com/tencent/mm/plugin/game/commlib/a:xvl	Lcom/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse;
    //   160: aload 5
    //   162: getfield 254	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:downloaderApp	Lcom/tencent/mm/plugin/game/protobuf/y;
    //   165: ifnull +27 -> 192
    //   168: invokestatic 260	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   171: invokevirtual 266	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   174: getstatic 272	com/tencent/mm/storage/ar$a:Ohq	Lcom/tencent/mm/storage/ar$a;
    //   177: getstatic 250	com/tencent/mm/plugin/game/commlib/a:xvl	Lcom/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse;
    //   180: getfield 254	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:downloaderApp	Lcom/tencent/mm/plugin/game/protobuf/y;
    //   183: getfield 278	com/tencent/mm/plugin/game/protobuf/y:xJU	Z
    //   186: invokestatic 283	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   189: invokevirtual 289	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   192: new 291	com/tencent/mm/vfs/o
    //   195: dup
    //   196: invokestatic 296	com/tencent/mm/plugin/game/commlib/util/b:dTg	()Ljava/lang/String;
    //   199: invokespecial 297	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   202: astore 6
    //   204: aload 6
    //   206: invokevirtual 301	com/tencent/mm/vfs/o:exists	()Z
    //   209: ifeq +11 -> 220
    //   212: aload 6
    //   214: invokevirtual 304	com/tencent/mm/vfs/o:isDirectory	()Z
    //   217: ifne +9 -> 226
    //   220: aload 6
    //   222: invokevirtual 307	com/tencent/mm/vfs/o:mkdirs	()Z
    //   225: pop
    //   226: aload 5
    //   228: invokevirtual 311	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:toByteArray	()[B
    //   231: astore 6
    //   233: new 313	com/tencent/mm/vfs/t
    //   236: dup
    //   237: invokestatic 316	com/tencent/mm/plugin/game/commlib/a:dSR	()Ljava/lang/String;
    //   240: invokespecial 317	com/tencent/mm/vfs/t:<init>	(Ljava/lang/String;)V
    //   243: astore 5
    //   245: aload 5
    //   247: aload 6
    //   249: invokevirtual 321	com/tencent/mm/vfs/t:write	([B)V
    //   252: aload 5
    //   254: ifnull +8 -> 262
    //   257: aload 5
    //   259: invokevirtual 324	com/tencent/mm/vfs/t:close	()V
    //   262: invokestatic 329	com/tencent/mm/plugin/game/commlib/e:dTe	()V
    //   265: invokestatic 334	com/tencent/mm/plugin/game/commlib/d/a:dpY	()V
    //   268: aload_0
    //   269: getfield 174	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/ak/i;
    //   272: iload_2
    //   273: iload_3
    //   274: aload 4
    //   276: aload_0
    //   277: invokeinterface 213 5 0
    //   282: ldc 183
    //   284: invokestatic 168	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: return
    //   288: astore 6
    //   290: aconst_null
    //   291: astore 5
    //   293: ldc_w 336
    //   296: new 185	java/lang/StringBuilder
    //   299: dup
    //   300: ldc_w 338
    //   303: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: aload 6
    //   308: invokevirtual 341	java/io/IOException:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: goto -68 -> 252
    //   323: astore 5
    //   325: goto -63 -> 262
    //   328: astore 6
    //   330: goto -37 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	c
    //   0	333	1	paramInt1	int
    //   0	333	2	paramInt2	int
    //   0	333	3	paramInt3	int
    //   0	333	4	paramString	String
    //   0	333	5	params	com.tencent.mm.network.s
    //   0	333	6	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   226	245	288	java/io/IOException
    //   257	262	323	java/io/IOException
    //   245	252	328	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.c
 * JD-Core Version:    0.7.0.1
 */