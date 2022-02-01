package com.tencent.mm.plugin.game.commlib;

import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.bj;
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
  private final d jTk;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(188504);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bj();
    ((d.a)localObject).lBV = new GetGameCenterGlobalSettingResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    bj localbj = (bj)d.b.b(this.jTk.lBR);
    localbj.CPt = LocaleUtil.getApplicationLanguage();
    String str = b.a.evu().evi();
    localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = Util.getSimCountryCode(MMApplicationContext.getContext());
    }
    localbj.mVH = ((String)localObject);
    localbj.CPu = ChannelUtil.channelId;
    localbj.CPv = new f();
    localbj.CPv.CMM = Build.VERSION.SDK_INT;
    localbj.CPv.CMN = YearClass.get(MMApplicationContext.getContext());
    localbj.CPw = paramInt;
    Log.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d, scene:%d", new Object[] { localbj.CPt, localbj.mVH, Integer.valueOf(localbj.CPu), Integer.valueOf(localbj.CPv.CMM), Integer.valueOf(localbj.CPv.CMN), Integer.valueOf(paramInt) });
    AppMethodBeat.o(188504);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(89936);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
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
    //   0: ldc 184
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 151
    //   7: new 186	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 188
    //   13: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_2
    //   17: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc 197
    //   22: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_3
    //   26: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc 202
    //   31: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 4
    //   36: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iload_2
    //   46: ifne +7 -> 53
    //   49: iload_3
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: getfield 175	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/an/i;
    //   57: iload_2
    //   58: iload_3
    //   59: aload 4
    //   61: aload_0
    //   62: invokeinterface 214 5 0
    //   67: ldc 184
    //   69: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: aload 5
    //   75: checkcast 65	com/tencent/mm/an/d
    //   78: getfield 218	com/tencent/mm/an/d:lBS	Lcom/tencent/mm/an/d$c;
    //   81: invokestatic 223	com/tencent/mm/an/d$c:b	(Lcom/tencent/mm/an/d$c;)Lcom/tencent/mm/cd/a;
    //   84: checkcast 33	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse
    //   87: astore 5
    //   89: aload 5
    //   91: ifnonnull +23 -> 114
    //   94: aload_0
    //   95: getfield 175	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/an/i;
    //   98: iload_2
    //   99: iload_3
    //   100: aload 4
    //   102: aload_0
    //   103: invokeinterface 214 5 0
    //   108: ldc 184
    //   110: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: ldc 225
    //   116: invokestatic 231	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   119: astore 6
    //   121: aload 6
    //   123: ifnull +13 -> 136
    //   126: aload 6
    //   128: ldc 233
    //   130: ldc 235
    //   132: invokevirtual 239	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: pop
    //   136: ldc 151
    //   138: ldc 241
    //   140: iconst_1
    //   141: anewarray 155	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload 5
    //   148: invokestatic 247	com/tencent/mm/ae/g:bN	(Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: aastore
    //   152: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload 5
    //   157: putstatic 253	com/tencent/mm/plugin/game/commlib/a:Czb	Lcom/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse;
    //   160: aload 5
    //   162: getfield 257	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:downloaderApp	Lcom/tencent/mm/plugin/game/protobuf/z;
    //   165: ifnull +27 -> 192
    //   168: invokestatic 263	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   171: invokevirtual 269	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   174: getstatic 275	com/tencent/mm/storage/ar$a:VvG	Lcom/tencent/mm/storage/ar$a;
    //   177: getstatic 253	com/tencent/mm/plugin/game/commlib/a:Czb	Lcom/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse;
    //   180: getfield 257	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:downloaderApp	Lcom/tencent/mm/plugin/game/protobuf/z;
    //   183: getfield 281	com/tencent/mm/plugin/game/protobuf/z:COc	Z
    //   186: invokestatic 286	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   189: invokevirtual 292	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   192: new 294	com/tencent/mm/vfs/q
    //   195: dup
    //   196: invokestatic 299	com/tencent/mm/plugin/game/commlib/e/c:ewp	()Ljava/lang/String;
    //   199: invokespecial 300	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   202: astore 6
    //   204: aload 6
    //   206: invokevirtual 304	com/tencent/mm/vfs/q:ifE	()Z
    //   209: ifeq +11 -> 220
    //   212: aload 6
    //   214: invokevirtual 307	com/tencent/mm/vfs/q:isDirectory	()Z
    //   217: ifne +9 -> 226
    //   220: aload 6
    //   222: invokevirtual 310	com/tencent/mm/vfs/q:ifL	()Z
    //   225: pop
    //   226: aload 5
    //   228: invokevirtual 314	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:toByteArray	()[B
    //   231: astore 6
    //   233: new 316	com/tencent/mm/vfs/w
    //   236: dup
    //   237: invokestatic 319	com/tencent/mm/plugin/game/commlib/a:evZ	()Ljava/lang/String;
    //   240: invokespecial 320	com/tencent/mm/vfs/w:<init>	(Ljava/lang/String;)V
    //   243: astore 5
    //   245: aload 5
    //   247: aload 6
    //   249: invokevirtual 324	com/tencent/mm/vfs/w:write	([B)V
    //   252: aload 5
    //   254: ifnull +8 -> 262
    //   257: aload 5
    //   259: invokevirtual 327	com/tencent/mm/vfs/w:close	()V
    //   262: invokestatic 332	com/tencent/mm/plugin/game/commlib/e:ewn	()V
    //   265: invokestatic 337	com/tencent/mm/plugin/game/commlib/d/a:dRf	()V
    //   268: aload_0
    //   269: getfield 175	com/tencent/mm/plugin/game/commlib/c:callback	Lcom/tencent/mm/an/i;
    //   272: iload_2
    //   273: iload_3
    //   274: aload 4
    //   276: aload_0
    //   277: invokeinterface 214 5 0
    //   282: ldc 184
    //   284: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: return
    //   288: astore 6
    //   290: aconst_null
    //   291: astore 5
    //   293: ldc_w 339
    //   296: new 186	java/lang/StringBuilder
    //   299: dup
    //   300: ldc_w 341
    //   303: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: aload 6
    //   308: invokevirtual 344	java/io/IOException:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 347	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.c
 * JD-Core Version:    0.7.0.1
 */