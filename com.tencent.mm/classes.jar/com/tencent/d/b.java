package com.tencent.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.n;
import java.util.ArrayList;
import java.util.HashMap;

public final class b
{
  public static final class a
  {
    ArrayList BOZ;
    Long BOd;
    String BPc;
    ArrayList RIo;
    Long RIp;
    Boolean RIq;
    String cachePath;
    String musicUrl;
  }
  
  public static final class aa
  {
    Long RHG;
    
    public final void p(Long paramLong)
    {
      this.RHG = paramLong;
    }
  }
  
  public static final class ab
  {
    Long RHm;
    
    public final Long hjS()
    {
      return this.RHm;
    }
  }
  
  public static final class ac
  {
    Long RHn;
    String md5;
    
    public final String getMd5()
    {
      return this.md5;
    }
    
    public final Long hjC()
    {
      return this.RHn;
    }
  }
  
  public static final class ad
  {
    Long RIp;
    String cachePath;
    String musicUrl;
    
    public final String azM()
    {
      return this.cachePath;
    }
    
    public final Long hjV()
    {
      return this.RIp;
    }
    
    public final String hjW()
    {
      return this.musicUrl;
    }
  }
  
  public static final class ae
  {
    String RJd;
    Long RJe;
  }
  
  public static final class af
  {
    Long RJf;
    String name;
    
    public final String getName()
    {
      return this.name;
    }
    
    public final Long hjX()
    {
      return this.RJf;
    }
  }
  
  public static final class ag
  {
    ArrayList BOZ;
    Long BOd;
    String BPc;
    Long RIp;
    Boolean RIq;
    ArrayList RJg;
    String cachePath;
    String musicUrl;
    String playUrl;
  }
  
  public static final class ah
  {
    byte[] RJh;
    String path;
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final byte[] hjY()
    {
      return this.RJh;
    }
  }
  
  public static final class ai
  {
    String productId;
    
    public final String getProductId()
    {
      return this.productId;
    }
  }
  
  public static final class aj
  {
    private String result;
    
    public final void bpS(String paramString)
    {
      this.result = paramString;
    }
    
    final HashMap hjw()
    {
      AppMethodBeat.i(196105);
      HashMap localHashMap = new HashMap();
      localHashMap.put("result", this.result);
      AppMethodBeat.o(196105);
      return localHashMap;
    }
  }
  
  public static final class ak
  {
    private String RJi;
    
    static ak y(HashMap paramHashMap)
    {
      AppMethodBeat.i(196106);
      ak localak = new ak();
      localak.RJi = ((String)paramHashMap.get("requestName"));
      AppMethodBeat.o(196106);
      return localak;
    }
    
    public final String hjZ()
    {
      return this.RJi;
    }
  }
  
  public static final class al
  {
    String RJj;
    
    public final void bpT(String paramString)
    {
      this.RJj = paramString;
    }
  }
  
  public static final class am
  {
    ArrayList RIN;
    
    public final void bw(ArrayList paramArrayList)
    {
      this.RIN = paramArrayList;
    }
  }
  
  public static final class an
  {
    String RJk;
    String text;
    
    public final String getText()
    {
      return this.text;
    }
    
    public final String hka()
    {
      return this.RJk;
    }
  }
  
  public static final class ao
  {
    Long RHn;
    Long RHq;
    Long RHr;
    Long RHs;
    Long RHt;
    Long RId;
    Long RIe;
    Long RIf;
    Double RIj;
    Double RJl;
    Long RJm;
    b.aq RJn;
    String path;
  }
  
  public static final class ap
  {
    String RJo;
    String RJp;
    String name;
  }
  
  public static final class aq
  {
    Long BOd;
    Long RHl;
    String path;
  }
  
  public static final class ar
  {
    Boolean RJa;
    
    public final void w(Boolean paramBoolean)
    {
      this.RJa = paramBoolean;
    }
  }
  
  public static abstract class as
  {
    public static void a(c paramc, as paramas)
    {
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.simple", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196107);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = b.ak.y((HashMap)paramAnonymousObject);
            localHashMap.put("result", this.RJq.a(paramAnonymousObject).hjw());
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196107);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.simple2", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196118);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = b.ak.y((HashMap)paramAnonymousObject);
            localHashMap.put("result", this.RJq.b(paramAnonymousObject).hjw());
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196118);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.testEmoji", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196129);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            Object localObject = new b.r();
            ((b.r)localObject).RIP = ((String)paramAnonymousObject.get("testRequest"));
            paramAnonymousObject = this.RJq.a((b.r)localObject);
            localObject = new HashMap();
            ((HashMap)localObject).put("testResponse", paramAnonymousObject.RIQ);
            ((HashMap)localObject).put("emojiDataList", paramAnonymousObject.RIR);
            ((HashMap)localObject).put("emojiBitmap", paramAnonymousObject.RIS);
            ((HashMap)localObject).put("base64Emoji", paramAnonymousObject.RIT);
            localHashMap.put("result", localObject);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196129);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getGroupProductId", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196140);
          paramAnonymousObject = new HashMap();
          try
          {
            b.x localx = this.RJq.dLw();
            HashMap localHashMap = new HashMap();
            localHashMap.put("packIconUrl", localx.RIX);
            localHashMap.put("productIdList", localx.RIY);
            localHashMap.put("packNameList", localx.RIZ);
            paramAnonymousObject.put("result", localHashMap);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196140);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getEmojiMd5ListByProductId", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196143);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            Object localObject = new b.v();
            ((b.v)localObject).productId = ((String)paramAnonymousObject.get("productId"));
            paramAnonymousObject = this.RJq.a((b.v)localObject);
            localObject = new HashMap();
            ((HashMap)localObject).put("md5List", paramAnonymousObject.RIN);
            ((HashMap)localObject).put("designerUin", paramAnonymousObject.RIV);
            ((HashMap)localObject).put("designerName", paramAnonymousObject.designerName);
            ((HashMap)localObject).put("designerHeadUrl", paramAnonymousObject.RIW);
            localHashMap.put("result", localObject);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196143);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getEmojiDataBase64", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196144);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            Object localObject = new b.p();
            ((b.p)localObject).productId = ((String)paramAnonymousObject.get("productId"));
            ((b.p)localObject).zfo = ((String)paramAnonymousObject.get("emojiMd5"));
            paramAnonymousObject = this.RJq.a((b.p)localObject);
            localObject = new HashMap();
            ((HashMap)localObject).put("uInt8List", paramAnonymousObject.RIM);
            ((HashMap)localObject).put("emojiName", paramAnonymousObject.RIO);
            ((HashMap)localObject).put("isSystemEmoji", paramAnonymousObject.wJQ);
            localHashMap.put("result", localObject);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196144);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getAudioRecommend", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196145);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            Object localObject = new b.c();
            ((b.c)localObject).path = ((String)localHashMap2.get("path"));
            paramAnonymousObject = localHashMap2.get("startTime");
            if (paramAnonymousObject != null) {
              break label139;
            }
            paramAnonymousObject = null;
            ((b.c)localObject).jnK = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("endTime");
            if (paramAnonymousObject != null) {
              break label174;
            }
            paramAnonymousObject = null;
            ((b.c)localObject).RIr = paramAnonymousObject;
            paramAnonymousObject = this.RJq.a((b.c)localObject);
            localObject = new HashMap();
            ((HashMap)localObject).put("audioInfoList", paramAnonymousObject.RIs);
            localHashMap1.put("result", localObject);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196145);
          return;
          label139:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label174:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.doMusicSearchRequest", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196146);
          localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.af localaf = new b.af();
            localaf.name = ((String)paramAnonymousObject.get("name"));
            paramAnonymousObject = paramAnonymousObject.get("searchOffset");
            if (paramAnonymousObject != null) {
              break label93;
            }
            paramAnonymousObject = null;
            localaf.RJf = paramAnonymousObject;
            this.RJq.a(localaf);
            localHashMap.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap);
          AppMethodBeat.o(196146);
          return;
          label93:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getCustomEmojiData", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196147);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            Object localObject = new b.l();
            ((b.l)localObject).md5 = ((String)paramAnonymousObject.get("md5"));
            paramAnonymousObject = this.RJq.a((b.l)localObject);
            localObject = new HashMap();
            ((HashMap)localObject).put("uInt8List", paramAnonymousObject.RIM);
            localHashMap.put("result", localObject);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196147);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getCustomEmojiMd5List", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196108);
          paramAnonymousObject = new HashMap();
          try
          {
            b.m localm = this.RJq.dLA();
            HashMap localHashMap = new HashMap();
            localHashMap.put("md5List", localm.RIN);
            paramAnonymousObject.put("result", localHashMap);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196108);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getSystemEmojiMd5List", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196109);
          paramAnonymousObject = new HashMap();
          try
          {
            b.am localam = this.RJq.dLB();
            HashMap localHashMap = new HashMap();
            localHashMap.put("md5List", localam.RIN);
            paramAnonymousObject.put("result", localHashMap);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196109);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getCustomEmojiCapture", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196110);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            Object localObject = new b.i();
            ((b.i)localObject).md5 = ((String)paramAnonymousObject.get("md5"));
            paramAnonymousObject = this.RJq.a((b.i)localObject);
            localObject = new HashMap();
            ((HashMap)localObject).put("uInt8List", paramAnonymousObject.RIM);
            localHashMap.put("result", localObject);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196110);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getCustomEmojiCaptureMd5List", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196111);
          paramAnonymousObject = new HashMap();
          try
          {
            b.k localk = this.RJq.dLC();
            HashMap localHashMap = new HashMap();
            localHashMap.put("md5List", localk.RIN);
            paramAnonymousObject.put("result", localHashMap);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196111);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getEmojiGIFData", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196112);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            Object localObject = new b.t();
            ((b.t)localObject).md5 = ((String)paramAnonymousObject.get("md5"));
            paramAnonymousObject = this.RJq.a((b.t)localObject);
            localObject = new HashMap();
            ((HashMap)localObject).put("heigth", paramAnonymousObject.RIU);
            ((HashMap)localObject).put("width", paramAnonymousObject.RHy);
            ((HashMap)localObject).put("data", paramAnonymousObject.data);
            localHashMap.put("result", localObject);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196112);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.MoveEmojiToFront", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196113);
          localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.ac localac = new b.ac();
            localac.md5 = ((String)paramAnonymousObject.get("md5"));
            paramAnonymousObject = paramAnonymousObject.get("type");
            if (paramAnonymousObject != null) {
              break label93;
            }
            paramAnonymousObject = null;
            localac.RHn = paramAnonymousObject;
            this.RJq.a(localac);
            localHashMap.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap);
          AppMethodBeat.o(196113);
          return;
          label93:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.DeleteEmoji", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196114);
          localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.o localo = new b.o();
            localo.md5 = ((String)paramAnonymousObject.get("md5"));
            paramAnonymousObject = paramAnonymousObject.get("type");
            if (paramAnonymousObject != null) {
              break label93;
            }
            paramAnonymousObject = null;
            localo.RHn = paramAnonymousObject;
            this.RJq.a(localo);
            localHashMap.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap);
          AppMethodBeat.o(196114);
          return;
          label93:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getCaptionData", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196115);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.f localf = new b.f();
            paramAnonymousObject = localHashMap2.get("type");
            if (paramAnonymousObject != null) {
              break label96;
            }
            paramAnonymousObject = null;
            localf.RHn = paramAnonymousObject;
            localf.filePath = ((String)localHashMap2.get("filePath"));
            this.RJq.a(localf);
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196115);
          return;
          label96:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.downloadMusic", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196116);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.ad localad = new b.ad();
            paramAnonymousObject = localHashMap2.get("musicId");
            if (paramAnonymousObject != null) {
              break label111;
            }
            paramAnonymousObject = null;
            localad.RIp = paramAnonymousObject;
            localad.musicUrl = ((String)localHashMap2.get("musicUrl"));
            localad.cachePath = ((String)localHashMap2.get("cachePath"));
            this.RJq.a(localad);
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196116);
          return;
          label111:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.showeEmojiGroupDetail", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196117);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.ai localai = new b.ai();
            localai.productId = ((String)paramAnonymousObject.get("productId"));
            this.RJq.a(localai);
            localHashMap.put("result", null);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196117);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getTransitionData", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196119);
          paramAnonymousObject = new HashMap();
          try
          {
            this.RJq.dLx();
            paramAnonymousObject.put("result", null);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196119);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.saveImageByteToPath", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196120);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.ah localah = new b.ah();
            localah.RJh = ((byte[])paramAnonymousObject.get("imageByte"));
            localah.path = ((String)paramAnonymousObject.get("path"));
            this.RJq.a(localah);
            localHashMap.put("result", null);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196120);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.jumpToPostUI", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196121);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = b.g.x((HashMap)paramAnonymousObject);
            this.RJq.a(paramAnonymousObject);
            localHashMap.put("result", null);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196121);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.jumpToPostUI2", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196122);
          localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.ab localab = new b.ab();
            paramAnonymousObject = paramAnonymousObject.get("id");
            if (paramAnonymousObject != null) {
              break label79;
            }
            paramAnonymousObject = null;
            localab.RHm = paramAnonymousObject;
            this.RJq.a(localab);
            localHashMap.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap);
          AppMethodBeat.o(196122);
          return;
          label79:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.checkFontFamilyRes", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196123);
          paramAnonymousObject = new HashMap();
          try
          {
            b.y localy = this.RJq.dLy();
            HashMap localHashMap = new HashMap();
            localHashMap.put("exist", localy.RJa);
            paramAnonymousObject.put("result", localHashMap);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196123);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.checkTransitionRes", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196124);
          paramAnonymousObject = new HashMap();
          try
          {
            b.ar localar = this.RJq.dLz();
            HashMap localHashMap = new HashMap();
            localHashMap.put("exist", localar.RJa);
            paramAnonymousObject.put("result", localHashMap);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196124);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getFontDataResponse", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196125);
          paramAnonymousObject = new HashMap();
          try
          {
            this.RJq.dLE();
            paramAnonymousObject.put("result", null);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196125);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.improveVideoQuality", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196126);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            new b.e().RIt = ((Boolean)paramAnonymousObject.get("requestBool"));
            localHashMap.put("result", null);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196126);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.idkeyStat", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196127);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.z localz = new b.z();
            paramAnonymousObject = localHashMap2.get("id");
            if (paramAnonymousObject != null) {
              break label121;
            }
            paramAnonymousObject = null;
            localz.RHm = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("key");
            if (paramAnonymousObject != null) {
              break label156;
            }
            paramAnonymousObject = null;
            localz.RJb = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("value");
            if (paramAnonymousObject != null) {
              break label191;
            }
            paramAnonymousObject = null;
            localz.RJc = paramAnonymousObject;
            this.RJq.a(localz);
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196127);
          return;
          label121:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label156:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label191:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getNetWorkType", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196128);
          paramAnonymousObject = new HashMap();
          try
          {
            b.aa localaa = this.RJq.dLD();
            HashMap localHashMap = new HashMap();
            localHashMap.put("result", localaa.RHG);
            paramAnonymousObject.put("result", localHashMap);
            paramAnonymousc.eO(paramAnonymousObject);
            AppMethodBeat.o(196128);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              paramAnonymousObject.put("error", b.q(localException));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.getVideoGOPStr", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196130);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            Object localObject = new b.at();
            ((b.at)localObject).RJr = ((ArrayList)paramAnonymousObject.get("videoPathList"));
            paramAnonymousObject = this.RJq.a((b.at)localObject);
            localObject = new HashMap();
            ((HashMap)localObject).put("reponseStr", paramAnonymousObject.RJj);
            localHashMap.put("result", localObject);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196130);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.textToSpeech", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196131);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.an localan = new b.an();
            localan.text = ((String)paramAnonymousObject.get("text"));
            localan.RJk = ((String)paramAnonymousObject.get("uniqueKeyId"));
            this.RJq.a(localan);
            localHashMap.put("result", null);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196131);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196132);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.b localb = new b.b();
            localb.BPp = ((String)localHashMap2.get("lrc"));
            paramAnonymousObject = localHashMap2.get("startTime");
            if (paramAnonymousObject != null) {
              break label114;
            }
            paramAnonymousObject = null;
            localb.jnK = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("endTime");
            if (paramAnonymousObject != null) {
              break label149;
            }
            paramAnonymousObject = null;
            localb.RIr = paramAnonymousObject;
            this.RJq.dLF();
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196132);
          return;
          label114:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label149:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember2", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196133);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.a locala = new b.a();
            locala.cachePath = ((String)localHashMap2.get("cachePath"));
            locala.musicUrl = ((String)localHashMap2.get("musicUrl"));
            paramAnonymousObject = localHashMap2.get("duration");
            if (paramAnonymousObject != null) {
              break label189;
            }
            paramAnonymousObject = null;
            locala.BOd = paramAnonymousObject;
            locala.RIo = ((ArrayList)localHashMap2.get("lrcList"));
            locala.BOZ = ((ArrayList)localHashMap2.get("singers"));
            locala.BPc = ((String)localHashMap2.get("songName"));
            paramAnonymousObject = localHashMap2.get("musicId");
            if (paramAnonymousObject != null) {
              break label224;
            }
            paramAnonymousObject = null;
            locala.RIp = paramAnonymousObject;
            locala.RIq = ((Boolean)localHashMap2.get("cached"));
            this.RJq.dLG();
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196133);
          return;
          label189:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label224:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember3", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196134);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.ag localag = new b.ag();
            localag.musicUrl = ((String)localHashMap2.get("musicUrl"));
            localag.BPc = ((String)localHashMap2.get("songName"));
            localag.playUrl = ((String)localHashMap2.get("playUrl"));
            paramAnonymousObject = localHashMap2.get("duration");
            if (paramAnonymousObject != null) {
              break label204;
            }
            paramAnonymousObject = null;
            localag.BOd = paramAnonymousObject;
            localag.RIq = ((Boolean)localHashMap2.get("cached"));
            paramAnonymousObject = localHashMap2.get("musicId");
            if (paramAnonymousObject != null) {
              break label239;
            }
            paramAnonymousObject = null;
            localag.RIp = paramAnonymousObject;
            localag.BOZ = ((ArrayList)localHashMap2.get("singers"));
            localag.RJg = ((ArrayList)localHashMap2.get("lrcInfoList"));
            localag.cachePath = ((String)localHashMap2.get("cachePath"));
            this.RJq.dLH();
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196134);
          return;
          label204:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label239:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember4", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196135);
          localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.ae localae = new b.ae();
            localae.RJd = ((String)paramAnonymousObject.get("lrcContent"));
            paramAnonymousObject = paramAnonymousObject.get("startPlayTime");
            if (paramAnonymousObject != null) {
              break label91;
            }
            paramAnonymousObject = null;
            localae.RJe = paramAnonymousObject;
            this.RJq.dLI();
            localHashMap.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap);
          AppMethodBeat.o(196135);
          return;
          label91:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember5", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196136);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            b.ap localap = new b.ap();
            localap.name = ((String)paramAnonymousObject.get("name"));
            localap.RJo = ((String)paramAnonymousObject.get("svgName"));
            localap.RJp = ((String)paramAnonymousObject.get("effectPath"));
            this.RJq.dLJ();
            localHashMap.put("result", null);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196136);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember10", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196137);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.aq localaq = new b.aq();
            localaq.path = ((String)localHashMap2.get("path"));
            paramAnonymousObject = localHashMap2.get("effectId");
            if (paramAnonymousObject != null) {
              break label114;
            }
            paramAnonymousObject = null;
            localaq.RHl = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("duration");
            if (paramAnonymousObject != null) {
              break label149;
            }
            paramAnonymousObject = null;
            localaq.BOd = paramAnonymousObject;
            this.RJq.dLO();
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196137);
          return;
          label114:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label149:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember6", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196138);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.ao localao = new b.ao();
            localao.path = ((String)localHashMap2.get("path"));
            paramAnonymousObject = localHashMap2.get("type");
            if (paramAnonymousObject != null) {
              break label299;
            }
            paramAnonymousObject = null;
            localao.RHn = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("startTimeMs");
            if (paramAnonymousObject != null) {
              break label334;
            }
            paramAnonymousObject = null;
            localao.RHq = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("endTimeMs");
            if (paramAnonymousObject != null) {
              break label369;
            }
            paramAnonymousObject = null;
            localao.RHr = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("trackStartTimeMs");
            if (paramAnonymousObject != null) {
              break label404;
            }
            paramAnonymousObject = null;
            localao.RHs = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("trackEndTimeMs");
            if (paramAnonymousObject != null) {
              break label439;
            }
            paramAnonymousObject = null;
            localao.RHt = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("sourceDuration");
            if (paramAnonymousObject != null) {
              break label474;
            }
            paramAnonymousObject = null;
            localao.RId = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("sourceWidth");
            if (paramAnonymousObject != null) {
              break label509;
            }
            paramAnonymousObject = null;
            localao.RIe = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("sourceHeight");
            if (paramAnonymousObject != null) {
              break label544;
            }
            paramAnonymousObject = null;
            localao.RIf = paramAnonymousObject;
            localao.RJl = ((Double)localHashMap2.get("sourceScale"));
            localao.RIj = ((Double)localHashMap2.get("volume"));
            paramAnonymousObject = localHashMap2.get("fromCamera");
            if (paramAnonymousObject != null) {
              break label579;
            }
            paramAnonymousObject = null;
            localao.RJm = paramAnonymousObject;
            localao.RJn = ((b.aq)localHashMap2.get("transitionInfoProto"));
            this.RJq.dLK();
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196138);
          return;
          label299:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label334:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label369:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label404:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label439:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label474:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label509:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label544:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label579:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember7", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196139);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.au localau = new b.au();
            localau.IFw = ((String)localHashMap2.get("templatePath"));
            localau.iiv = ((String)localHashMap2.get("musicPath"));
            paramAnonymousObject = localHashMap2.get("duration");
            if (paramAnonymousObject != null) {
              break label124;
            }
            paramAnonymousObject = null;
            localau.BOd = paramAnonymousObject;
            localau.RJs = ((Boolean)localHashMap2.get("trackCropToTemplateSize"));
            this.RJq.dLL();
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196139);
          return;
          label124:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember8", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196141);
          localHashMap1 = new HashMap();
          try
          {
            HashMap localHashMap2 = (HashMap)paramAnonymousObject;
            b.h localh = new b.h();
            paramAnonymousObject = localHashMap2.get("absSwitch");
            if (paramAnonymousObject != null) {
              break label324;
            }
            paramAnonymousObject = null;
            localh.RIE = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("audioBitrate");
            if (paramAnonymousObject != null) {
              break label359;
            }
            paramAnonymousObject = null;
            localh.RHD = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("audioChannelCount");
            if (paramAnonymousObject != null) {
              break label394;
            }
            paramAnonymousObject = null;
            localh.RHF = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("audioSampleRate");
            if (paramAnonymousObject != null) {
              break label429;
            }
            paramAnonymousObject = null;
            localh.RHE = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("fps");
            if (paramAnonymousObject != null) {
              break label464;
            }
            paramAnonymousObject = null;
            localh.RHB = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("iFrame");
            if (paramAnonymousObject != null) {
              break label499;
            }
            paramAnonymousObject = null;
            localh.RIF = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("originHeight");
            if (paramAnonymousObject != null) {
              break label534;
            }
            paramAnonymousObject = null;
            localh.RIG = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("originWidth");
            if (paramAnonymousObject != null) {
              break label569;
            }
            paramAnonymousObject = null;
            localh.RIH = paramAnonymousObject;
            localh.RII = ((ArrayList)localHashMap2.get("originRect"));
            localh.rpE = ((String)localHashMap2.get("outputPath"));
            localh.RIJ = ((Double)localHashMap2.get("outputScale"));
            paramAnonymousObject = localHashMap2.get("targetHeight");
            if (paramAnonymousObject != null) {
              break label604;
            }
            paramAnonymousObject = null;
            localh.RIK = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("targetWidth");
            if (paramAnonymousObject != null) {
              break label639;
            }
            paramAnonymousObject = null;
            localh.RIL = paramAnonymousObject;
            paramAnonymousObject = localHashMap2.get("videoBitrate");
            if (paramAnonymousObject != null) {
              break label674;
            }
            paramAnonymousObject = null;
            localh.RHA = paramAnonymousObject;
            this.RJq.dLM();
            localHashMap1.put("result", null);
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              long l;
              localHashMap1.put("error", b.q(paramAnonymousObject));
            }
          }
          paramAnonymousc.eO(localHashMap1);
          AppMethodBeat.o(196141);
          return;
          label324:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label359:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label394:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label429:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label464:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label499:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label534:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label569:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label604:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label639:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
          label674:
          if ((paramAnonymousObject instanceof Integer)) {}
          for (l = ((Integer)paramAnonymousObject).intValue();; l = ((Long)paramAnonymousObject).longValue())
          {
            paramAnonymousObject = Long.valueOf(l);
            break;
          }
        }
      });
      new io.flutter.plugin.a.b(paramc, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember9", new n()).a(new io.flutter.plugin.a.b.b()
      {
        public final void a(Object paramAnonymousObject, io.flutter.plugin.a.b.c<Object> paramAnonymousc)
        {
          AppMethodBeat.i(196142);
          HashMap localHashMap = new HashMap();
          try
          {
            b.g.x((HashMap)paramAnonymousObject);
            this.RJq.dLN();
            localHashMap.put("result", null);
            paramAnonymousc.eO(localHashMap);
            AppMethodBeat.o(196142);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", b.q(paramAnonymousObject));
            }
          }
        }
      });
    }
    
    public abstract b.aj a(b.ak paramak);
    
    public abstract b.al a(b.at paramat);
    
    public abstract b.d a(b.c paramc);
    
    public abstract b.j a(b.i parami);
    
    public abstract b.n a(b.l paraml);
    
    public abstract b.q a(b.p paramp);
    
    public abstract b.s a(b.r paramr);
    
    public abstract b.u a(b.t paramt);
    
    public abstract b.w a(b.v paramv);
    
    public abstract void a(b.ab paramab);
    
    public abstract void a(b.ac paramac);
    
    public abstract void a(b.ad paramad);
    
    public abstract void a(b.af paramaf);
    
    public abstract void a(b.ah paramah);
    
    public abstract void a(b.ai paramai);
    
    public abstract void a(b.an paraman);
    
    public abstract void a(b.f paramf);
    
    public abstract void a(b.g paramg);
    
    public abstract void a(b.o paramo);
    
    public abstract void a(b.z paramz);
    
    public abstract b.aj b(b.ak paramak);
    
    public abstract b.m dLA();
    
    public abstract b.am dLB();
    
    public abstract b.k dLC();
    
    public abstract b.aa dLD();
    
    public abstract void dLE();
    
    public abstract void dLF();
    
    public abstract void dLG();
    
    public abstract void dLH();
    
    public abstract void dLI();
    
    public abstract void dLJ();
    
    public abstract void dLK();
    
    public abstract void dLL();
    
    public abstract void dLM();
    
    public abstract void dLN();
    
    public abstract void dLO();
    
    public abstract b.x dLw();
    
    public abstract void dLx();
    
    public abstract b.y dLy();
    
    public abstract b.ar dLz();
  }
  
  public static final class at
  {
    ArrayList RJr;
    
    public final ArrayList hkb()
    {
      return this.RJr;
    }
  }
  
  public static final class au
  {
    Long BOd;
    String IFw;
    Boolean RJs;
    String iiv;
  }
  
  public static final class b
  {
    String BPp;
    Long RIr;
    Long jnK;
  }
  
  public static final class c
  {
    Long RIr;
    Long jnK;
    String path;
    
    public final String getPath()
    {
      return this.path;
    }
    
    public final Long hjA()
    {
      return this.jnK;
    }
    
    public final Long hjB()
    {
      return this.RIr;
    }
  }
  
  public static final class d
  {
    ArrayList RIs;
  }
  
  public static final class e
  {
    Boolean RIt;
  }
  
  public static final class f
  {
    Long RHn;
    String filePath;
    
    public final String getFilePath()
    {
      return this.filePath;
    }
    
    public final Long hjC()
    {
      return this.RHn;
    }
  }
  
  public static final class h
  {
    Long RHA;
    Long RHB;
    Long RHD;
    Long RHE;
    Long RHF;
    Long RIE;
    Long RIF;
    Long RIG;
    Long RIH;
    ArrayList RII;
    Double RIJ;
    Long RIK;
    Long RIL;
    String rpE;
  }
  
  public static final class i
  {
    String md5;
    
    public final String getMd5()
    {
      return this.md5;
    }
  }
  
  public static final class j
  {
    byte[] RIM;
    
    public final void cS(byte[] paramArrayOfByte)
    {
      this.RIM = paramArrayOfByte;
    }
  }
  
  public static final class k
  {
    ArrayList RIN;
    
    public final void bw(ArrayList paramArrayList)
    {
      this.RIN = paramArrayList;
    }
  }
  
  public static final class l
  {
    String md5;
    
    public final String getMd5()
    {
      return this.md5;
    }
  }
  
  public static final class m
  {
    ArrayList RIN;
    
    public final void bw(ArrayList paramArrayList)
    {
      this.RIN = paramArrayList;
    }
  }
  
  public static final class n
  {
    byte[] RIM;
    
    public final void cS(byte[] paramArrayOfByte)
    {
      this.RIM = paramArrayOfByte;
    }
  }
  
  public static final class o
  {
    Long RHn;
    String md5;
    
    public final String getMd5()
    {
      return this.md5;
    }
    
    public final Long hjC()
    {
      return this.RHn;
    }
  }
  
  public static final class p
  {
    String productId;
    String zfo;
    
    public final String getProductId()
    {
      return this.productId;
    }
    
    public final String hjP()
    {
      return this.zfo;
    }
  }
  
  public static final class q
  {
    byte[] RIM;
    String RIO;
    Boolean wJQ;
    
    public final void bpO(String paramString)
    {
      this.RIO = paramString;
    }
    
    public final void cS(byte[] paramArrayOfByte)
    {
      this.RIM = paramArrayOfByte;
    }
    
    public final void v(Boolean paramBoolean)
    {
      this.wJQ = paramBoolean;
    }
  }
  
  public static final class r
  {
    String RIP;
    
    public final String hjQ()
    {
      return this.RIP;
    }
  }
  
  public static final class s
  {
    String RIQ;
    ArrayList RIR;
    ArrayList RIS;
    ArrayList RIT;
    
    public final void bpP(String paramString)
    {
      this.RIQ = paramString;
    }
  }
  
  public static final class t
  {
    String md5;
    
    public final String getMd5()
    {
      return this.md5;
    }
  }
  
  public static final class u
  {
    Long RHy;
    Long RIU;
    byte[] data;
    
    public final void m(Long paramLong)
    {
      this.RIU = paramLong;
    }
    
    public final void n(Long paramLong)
    {
      this.RHy = paramLong;
    }
    
    public final void setData(byte[] paramArrayOfByte)
    {
      this.data = paramArrayOfByte;
    }
  }
  
  public static final class v
  {
    String productId;
    
    public final String getProductId()
    {
      return this.productId;
    }
  }
  
  public static final class w
  {
    ArrayList RIN;
    Long RIV;
    String RIW;
    String designerName;
    
    public final void bpQ(String paramString)
    {
      this.designerName = paramString;
    }
    
    public final void bpR(String paramString)
    {
      this.RIW = paramString;
    }
    
    public final void bw(ArrayList paramArrayList)
    {
      this.RIN = paramArrayList;
    }
    
    public final ArrayList hjR()
    {
      return this.RIN;
    }
    
    public final void o(Long paramLong)
    {
      this.RIV = paramLong;
    }
  }
  
  public static final class x
  {
    ArrayList RIX;
    ArrayList RIY;
    ArrayList RIZ;
    
    public final void bx(ArrayList paramArrayList)
    {
      this.RIX = paramArrayList;
    }
    
    public final void by(ArrayList paramArrayList)
    {
      this.RIY = paramArrayList;
    }
    
    public final void bz(ArrayList paramArrayList)
    {
      this.RIZ = paramArrayList;
    }
  }
  
  public static final class y
  {
    Boolean RJa;
    
    public final void w(Boolean paramBoolean)
    {
      this.RJa = paramBoolean;
    }
  }
  
  public static final class z
  {
    Long RHm;
    Long RJb;
    Long RJc;
    
    public final Long hjS()
    {
      return this.RHm;
    }
    
    public final Long hjT()
    {
      return this.RJb;
    }
    
    public final Long hjU()
    {
      return this.RJc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.d.b
 * JD-Core Version:    0.7.0.1
 */