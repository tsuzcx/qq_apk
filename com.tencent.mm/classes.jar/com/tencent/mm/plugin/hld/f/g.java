package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.text.Spanned;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.e;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.emoji.c;
import com.tencent.mm.plugin.hld.emoji.k;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.fmu;
import com.tencent.mm.protocal.protobuf.fmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.h.c.b;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeEmojiUtil;", "", "()V", "TAG", "", "allEmojiMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "Lkotlin/collections/HashMap;", "allEmojiTypeMap", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiDataList;", "emojiBitmapMap", "Landroid/graphics/Bitmap;", "emojiSubTypeArrayList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "historyListenerMap", "Lkotlin/Function0;", "", "getHistoryListenerMap", "()Ljava/util/HashMap;", "setHistoryListenerMap", "(Ljava/util/HashMap;)V", "historyPath", "kaoemojiSubTypeArrayList", "mIRecentEmojiListenerWr", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/hld/emoji/IRecentEmojiListener;", "recentEmojiMap", "appendHistory", "emojiType", "emojiData", "appendHistoryFromCandidate", "candidate", "clear", "getAllEmojiByType", "context", "Landroid/content/Context;", "typeName", "subTypeName", "getEmojiBitmap", "getEmojiPath", "getEmojiSubType", "index", "", "getEmojiSubTypeData", "getHistory", "getKaoEmojiSubType", "getKaoEmojiSubTypeData", "getLastEmojiSubType", "getLastEmojiType", "getSubTypeByEmojiType", "parseHistory", "saveHistory", "recentEmojiList", "saveLastEmojiSubType", "subType", "saveLastEmojiType", "setIRecentEmojiListener", "listener", "unZipEmojiFile", "plugin-hld_release"})
public final class g
{
  private static final String DGY;
  private static final ArrayList<k> DGZ;
  private static final ArrayList<k> DHa;
  private static final HashMap<String, fmv> DHb;
  private static final HashMap<String, fmv> DHc;
  private static final HashMap<String, fmu> DHd;
  private static final HashMap<String, Bitmap> DHe;
  private static WeakReference<c> DHf;
  private static HashMap<String, kotlin.g.a.a<x>> DHg;
  public static final g DHh;
  
  static
  {
    AppMethodBeat.i(216749);
    DHh = new g();
    StringBuilder localStringBuilder = new StringBuilder();
    l locall = l.DHK;
    localStringBuilder = localStringBuilder.append(l.eGU()).append("/emoji");
    locall = l.DHK;
    DGY = l.eGZ();
    DGZ = new ArrayList();
    DHa = new ArrayList();
    DHb = new HashMap();
    DHc = new HashMap();
    DHd = new HashMap();
    DHe = new HashMap();
    DHg = new HashMap();
    aLJ("emoji");
    aLJ("kaoemoji");
    AppMethodBeat.o(216749);
  }
  
  public static fmv K(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(216735);
    p.k(paramContext, "context");
    p.k(paramString1, "typeName");
    p.k(paramString2, "subTypeName");
    if (Util.isEqual(paramString2, "recent"))
    {
      paramContext = new fmv();
      paramContext.MGI.addAll((Collection)aLI(paramString1).MGI);
      AppMethodBeat.o(216735);
      return paramContext;
    }
    Object localObject1 = paramString1 + paramString2;
    if (DHc.get(localObject1) != null)
    {
      paramContext = DHc.get(localObject1);
      if (paramContext == null) {
        p.iCn();
      }
      paramContext = (fmv)paramContext;
      AppMethodBeat.o(216735);
      return paramContext;
    }
    if (Util.isEqual(paramString1, "emoji"))
    {
      localObject1 = "emoji/";
      paramContext = paramContext.getAssets().open((String)localObject1 + paramString2 + ".txt");
      p.j(paramContext, "context.assets.open(file…ASSETS_EMOJI_FILE_SUFFIX)");
      localObject1 = new BufferedReader((Reader)new InputStreamReader(paramContext));
      paramContext = new fmv();
    }
    try
    {
      for (;;)
      {
        localObject2 = ((BufferedReader)localObject1).readLine();
        if (localObject2 == null) {
          break;
        }
        if (localObject2 != null)
        {
          fmu localfmu = new fmu();
          switch (paramString1.hashCode())
          {
          case 96632902: 
            paramContext.MGI.add(localfmu);
          }
        }
      }
    }
    catch (IOException localIOException3)
    {
      Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + paramString2 + ' ' + localIOException3.getMessage());
    }
    finally
    {
      for (;;)
      {
        try
        {
          ((BufferedReader)localObject1).close();
          ((Map)DHc).put(paramString1 + paramString2, paramContext);
          AppMethodBeat.o(216735);
          return paramContext;
          localObject1 = "kaoemoji/";
          break;
          if (paramString1.equals("emoji"))
          {
            Object localObject4 = n.b((CharSequence)localObject2, new String[] { " " });
            localObject3 = new StringBuilder();
            localObject4 = ((List)localObject4).iterator();
            if (((Iterator)localObject4).hasNext())
            {
              ((StringBuilder)localObject3).append(Character.toChars(Integer.parseInt((String)((Iterator)localObject4).next(), kotlin.n.a.aFL(16))));
              continue;
              paramContext = finally;
            }
          }
        }
        catch (IOException localIOException2)
        {
          try
          {
            Object localObject2;
            Object localObject3;
            ((BufferedReader)localObject1).close();
            AppMethodBeat.o(216735);
            throw paramContext;
            if (paramString1.equals("kaoemoji"))
            {
              localIOException3.content = ((String)localObject2);
              continue;
              localIOException3.content = ((StringBuilder)localObject3).toString();
              localIOException3.MGH = ((String)localObject2);
              localObject2 = (Map)DHd;
              localObject3 = localIOException3.content;
              p.j(localObject3, "emojiData.content");
              t localt;
              if (localObject3 == null)
              {
                localt = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(216735);
                throw localt;
              }
              localObject3 = ((String)localObject3).toLowerCase();
              p.j(localObject3, "(this as java.lang.String).toLowerCase()");
              ((Map)localObject2).put(localObject3, localt);
              continue;
              try
              {
                ((BufferedReader)localObject1).close();
              }
              catch (IOException localIOException1)
              {
                Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + paramString2 + ' ' + localIOException1.getMessage());
              }
              continue;
              localIOException2 = localIOException2;
              Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + paramString2 + ' ' + localIOException2.getMessage());
            }
          }
          catch (IOException paramString1)
          {
            Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + paramString2 + ' ' + paramString1.getMessage());
          }
        }
      }
    }
  }
  
  public static String UH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "recent";
    case 1: 
      return "emotion";
    case 2: 
      return "limbs";
    case 3: 
      return "person";
    case 4: 
      return "animal";
    case 5: 
      return "botany";
    case 6: 
      return "nature";
    case 7: 
      return "food";
    case 8: 
      return "place";
    case 9: 
      return "traffic";
    case 10: 
      return "exercise";
    case 11: 
      return "goods";
    case 12: 
      return "symbol";
    }
    return "flag";
  }
  
  public static String UI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "recent";
    case 1: 
      return "happy";
    case 2: 
      return "acting_cute";
    case 3: 
      return "anger";
    case 4: 
      return "sad";
    case 5: 
      return "speechless";
    }
    return "amazed";
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(216730);
    p.k(paramc, "listener");
    DHf = new WeakReference(paramc);
    AppMethodBeat.o(216730);
  }
  
  public static void a(String paramString, fmu paramfmu)
  {
    AppMethodBeat.i(216745);
    p.k(paramString, "emojiType");
    if (paramfmu == null)
    {
      AppMethodBeat.o(216745);
      return;
    }
    fmv localfmv = aLI(paramString);
    Object localObject = localfmv.MGI;
    p.j(localObject, "recentEmojiList.emojiDataList");
    Iterator localIterator = ((List)localObject).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = ((fmu)localIterator.next()).content;
      if (paramfmu != null)
      {
        localObject = paramfmu.content;
        label90:
        if (!p.h(str, localObject)) {
          break label185;
        }
      }
    }
    for (;;)
    {
      if ((i >= 0) && (i < localfmv.MGI.size())) {
        localfmv.MGI.remove(i);
      }
      localfmv.MGI.add(0, paramfmu);
      if (localfmv.MGI.size() > 10) {
        localfmv.MGI.remove(localfmv.MGI.size() - 1);
      }
      a(paramString, localfmv);
      AppMethodBeat.o(216745);
      return;
      localObject = null;
      break label90;
      label185:
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static void a(String paramString, fmv paramfmv)
  {
    AppMethodBeat.i(216748);
    Object localObject = (kotlin.g.a.a)DHg.get(paramString);
    if (localObject != null) {
      ((kotlin.g.a.a)localObject).invoke();
    }
    localObject = paramfmv.toByteArray();
    u.bBD(DGY);
    u.H(DGY + paramString + ".proto", (byte[])localObject);
    Log.i("WxIme.WxImeEmojiUtil", "saveHistory: " + paramString + ' ' + paramfmv.MGI.size());
    AppMethodBeat.o(216748);
  }
  
  public static String aLG(String paramString)
  {
    AppMethodBeat.i(216738);
    p.k(paramString, "emojiType");
    String str;
    Object localObject;
    if (p.h(paramString, "emoji"))
    {
      str = "emotion";
      localObject = l.DHK;
      MultiProcessMMKV localMultiProcessMMKV = l.getKV();
      localObject = str;
      if (localMultiProcessMMKV != null)
      {
        localObject = localMultiProcessMMKV.getString(paramString, str);
        if (localObject != null) {
          break label68;
        }
        localObject = str;
      }
    }
    label68:
    for (;;)
    {
      AppMethodBeat.o(216738);
      return localObject;
      str = "happy";
      break;
    }
  }
  
  public static void aLH(String paramString)
  {
    AppMethodBeat.i(216741);
    p.k(paramString, "emojiType");
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString("emoji_last_type", paramString);
        AppMethodBeat.o(216741);
        return;
      }
    }
    AppMethodBeat.o(216741);
  }
  
  public static fmv aLI(String paramString)
  {
    AppMethodBeat.i(216742);
    p.k(paramString, "emojiType");
    fmv localfmv = (fmv)DHb.get(paramString);
    paramString = localfmv;
    if (localfmv == null) {
      paramString = new fmv();
    }
    AppMethodBeat.o(216742);
    return paramString;
  }
  
  private static void aLJ(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(216747);
    byte[] arrayOfByte = u.aY(DGY + paramString + ".proto", 0, -1);
    fmv localfmv = new fmv();
    if (arrayOfByte != null)
    {
      int i;
      if (arrayOfByte.length == 0) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          i = j;
          if (i == 0) {}
        }
        else
        {
          try
          {
            localfmv.parseFrom(arrayOfByte);
            DHb.put(paramString, localfmv);
            Log.i("WxIme.WxImeEmojiUtil", "parseHistory: " + paramString + ' ' + localfmv.MGI.size());
            AppMethodBeat.o(216747);
            return;
            i = 0;
            continue;
            i = 0;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("WxIme.WxImeEmojiUtil", (Throwable)localException, "", new Object[0]);
            }
          }
        }
      }
    }
    DHb.put(paramString, localfmv);
    AppMethodBeat.o(216747);
  }
  
  public static Bitmap b(fmu paramfmu)
  {
    AppMethodBeat.i(216734);
    p.k(paramfmu, "emojiData");
    if (DHe.containsKey(paramfmu.MGH))
    {
      paramfmu = (Bitmap)DHe.get(paramfmu.MGH);
      AppMethodBeat.o(216734);
      return paramfmu;
    }
    try
    {
      p.k(paramfmu, "emojiData");
      localObject1 = new StringBuilder();
      localObject2 = l.DHK;
      localObject1 = ((StringBuilder)localObject1).append(l.eGX()).append("/");
      localObject2 = paramfmu.MGH;
      p.j(localObject2, "emojiData.oriContent");
      localObject2 = n.l((String)localObject2, " ", "_", false);
      if (localObject2 == null)
      {
        paramfmu = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(216734);
        throw paramfmu;
      }
    }
    catch (Exception paramfmu)
    {
      Log.e("WxIme.WxImeEmojiUtil", "getEmojiBitmap " + paramfmu.getMessage());
      AppMethodBeat.o(216734);
      return null;
    }
    Object localObject2 = ((String)localObject2).toLowerCase();
    p.j(localObject2, "(this as java.lang.String).toLowerCase()");
    Object localObject1 = (String)localObject2 + ".wxam";
    Log.d("WxIme.WxImeEmojiUtil", "imgPath:".concat(String.valueOf(localObject1)));
    if (u.agG((String)localObject1))
    {
      localObject1 = MMGIFJNIFactory.Companion.decodeThumb(u.aY((String)localObject1, 0, -1));
      localObject2 = (Map)DHe;
      paramfmu = paramfmu.MGH;
      p.j(paramfmu, "emojiData.oriContent");
      ((Map)localObject2).put(paramfmu, localObject1);
    }
    for (paramfmu = (fmu)localObject1;; paramfmu = null)
    {
      AppMethodBeat.o(216734);
      return paramfmu;
    }
  }
  
  public static ArrayList<k> be(Context paramContext, String paramString)
  {
    AppMethodBeat.i(216736);
    p.k(paramContext, "context");
    p.k(paramString, "typeName");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        paramContext = new ArrayList();
        AppMethodBeat.o(216736);
        return paramContext;
      } while (!paramString.equals("emoji"));
      paramContext = gT(paramContext);
      AppMethodBeat.o(216736);
      return paramContext;
    } while (!paramString.equals("kaoemoji"));
    if (!((Collection)DHa).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramContext = DHa;
      AppMethodBeat.o(216736);
      return paramContext;
    }
    paramString = DHa;
    String str = paramContext.getString(a.j.ime_kaoemoji_subtype_recent);
    p.j(str, "context.getString(R.stri…_kaoemoji_subtype_recent)");
    paramString.add(new k(str, "recent"));
    paramString = DHa;
    str = paramContext.getString(a.j.ime_kaoemoji_subtype_happy);
    p.j(str, "context.getString(R.stri…e_kaoemoji_subtype_happy)");
    paramString.add(new k(str, "happy"));
    paramString = DHa;
    str = paramContext.getString(a.j.ime_kaoemoji_subtype_acting_cute);
    p.j(str, "context.getString(R.stri…moji_subtype_acting_cute)");
    paramString.add(new k(str, "acting_cute"));
    paramString = DHa;
    str = paramContext.getString(a.j.ime_kaoemoji_subtype_anger);
    p.j(str, "context.getString(R.stri…e_kaoemoji_subtype_anger)");
    paramString.add(new k(str, "anger"));
    paramString = DHa;
    str = paramContext.getString(a.j.ime_kaoemoji_subtype_sad);
    p.j(str, "context.getString(R.stri…ime_kaoemoji_subtype_sad)");
    paramString.add(new k(str, "sad"));
    paramString = DHa;
    str = paramContext.getString(a.j.ime_kaoemoji_subtype_speechless);
    p.j(str, "context.getString(R.stri…emoji_subtype_speechless)");
    paramString.add(new k(str, "speechless"));
    paramString = DHa;
    paramContext = paramContext.getString(a.j.ime_kaoemoji_subtype_amazed);
    p.j(paramContext, "context.getString(R.stri…_kaoemoji_subtype_amazed)");
    paramString.add(new k(paramContext, "amazed"));
    paramContext = DHa;
    AppMethodBeat.o(216736);
    return paramContext;
  }
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(216746);
    fmv localfmv = aLI(paramString);
    localfmv.MGI.clear();
    a(paramString, localfmv);
    AppMethodBeat.o(216746);
  }
  
  public static HashMap<String, kotlin.g.a.a<x>> eGx()
  {
    return DHg;
  }
  
  public static void eGy()
  {
    AppMethodBeat.i(216733);
    Object localObject = l.DHK;
    q localq = new q(l.eGX());
    localObject = localq.ifJ();
    if (localObject != null) {}
    for (int i = localObject.length; i > 0; i = 0)
    {
      Log.i("WxIme.WxImeEmojiUtil", "has emoji img!");
      AppMethodBeat.o(216733);
      return;
    }
    for (;;)
    {
      try
      {
        localObject = l.DHK;
        p.k("ime_emoji.zip", "name");
        localObject = com.tencent.mm.plugin.hld.c.a.DvH;
        localObject = ((Iterable)com.tencent.mm.plugin.hld.c.a.eCZ()).iterator();
        if (((Iterator)localObject).hasNext())
        {
          clh localclh = (clh)((Iterator)localObject).next();
          if (!Util.isEqual(localclh.name, "ime_emoji.zip")) {
            continue;
          }
          if (l.j(localclh))
          {
            localObject = localclh.path;
            p.j(localObject, "dict.path");
            i = o.a(new ZipInputStream(u.Tf((String)localObject)), localq.bOF());
            Log.i("WxIme.WxImeEmojiUtil", "unzip file from assets, path:" + (String)localObject + " result:" + i);
            AppMethodBeat.o(216733);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("WxIme.WxImeEmojiUtil", "unZipEmojiFile " + localException.getMessage());
        AppMethodBeat.o(216733);
        return;
      }
      String str = "";
    }
  }
  
  public static String eGz()
  {
    AppMethodBeat.i(216740);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      String str = ((MultiProcessMMKV)localObject).getString("emoji_last_type", "emoji");
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "emoji";
    }
    AppMethodBeat.o(216740);
    return localObject;
  }
  
  private static ArrayList<k> gT(Context paramContext)
  {
    AppMethodBeat.i(216737);
    if (!((Collection)DGZ).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramContext = DGZ;
      AppMethodBeat.o(216737);
      return paramContext;
    }
    Object localObject = l.DHK;
    if (!l.eCE())
    {
      localObject = DGZ;
      str = paramContext.getString(a.j.ime_emoji_subtype_recent);
      p.j(str, "context.getString(R.stri…ime_emoji_subtype_recent)");
      ((ArrayList)localObject).add(new k(str, "recent"));
    }
    localObject = DGZ;
    String str = paramContext.getString(a.j.ime_emoji_subtype_emotion);
    p.j(str, "context.getString(R.stri…me_emoji_subtype_emotion)");
    ((ArrayList)localObject).add(new k(str, "emotion"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_limbs);
    p.j(str, "context.getString(R.stri….ime_emoji_subtype_limbs)");
    ((ArrayList)localObject).add(new k(str, "limbs"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_person);
    p.j(str, "context.getString(R.stri…ime_emoji_subtype_person)");
    ((ArrayList)localObject).add(new k(str, "person"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_animal);
    p.j(str, "context.getString(R.stri…ime_emoji_subtype_animal)");
    ((ArrayList)localObject).add(new k(str, "animal"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_botany);
    p.j(str, "context.getString(R.stri…ime_emoji_subtype_botany)");
    ((ArrayList)localObject).add(new k(str, "botany"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_nature);
    p.j(str, "context.getString(R.stri…ime_emoji_subtype_nature)");
    ((ArrayList)localObject).add(new k(str, "nature"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_food);
    p.j(str, "context.getString(R.string.ime_emoji_subtype_food)");
    ((ArrayList)localObject).add(new k(str, "food"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_place);
    p.j(str, "context.getString(R.stri….ime_emoji_subtype_place)");
    ((ArrayList)localObject).add(new k(str, "place"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_traffic);
    p.j(str, "context.getString(R.stri…me_emoji_subtype_traffic)");
    ((ArrayList)localObject).add(new k(str, "traffic"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_exercise);
    p.j(str, "context.getString(R.stri…e_emoji_subtype_exercise)");
    ((ArrayList)localObject).add(new k(str, "exercise"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_goods);
    p.j(str, "context.getString(R.stri….ime_emoji_subtype_goods)");
    ((ArrayList)localObject).add(new k(str, "goods"));
    localObject = DGZ;
    str = paramContext.getString(a.j.ime_emoji_subtype_symbol);
    p.j(str, "context.getString(R.stri…ime_emoji_subtype_symbol)");
    ((ArrayList)localObject).add(new k(str, "symbol"));
    localObject = DGZ;
    paramContext = paramContext.getString(a.j.ime_emoji_subtype_flag);
    p.j(paramContext, "context.getString(R.string.ime_emoji_subtype_flag)");
    ((ArrayList)localObject).add(new k(paramContext, "flag"));
    paramContext = DGZ;
    AppMethodBeat.o(216737);
    return paramContext;
  }
  
  public static void ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216739);
    p.k(paramString1, "emojiType");
    p.k(paramString2, "subType");
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
        AppMethodBeat.o(216739);
        return;
      }
    }
    AppMethodBeat.o(216739);
  }
  
  public static void is(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216744);
    p.k(paramString1, "emojiType");
    if ((p.h(paramString1, "emoji") ^ true))
    {
      AppMethodBeat.o(216744);
      return;
    }
    if (paramString2 != null)
    {
      h.ZvG.be((Runnable)new a(paramString2));
      AppMethodBeat.o(216744);
      return;
    }
    AppMethodBeat.o(216744);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(209143);
      Object localObject2 = b.c(MMApplicationContext.getContext(), (CharSequence)this.DHi, 20.0F);
      if (!(localObject2 instanceof Spanned)) {}
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        localObject1 = (Spanned)localObject1;
        if (localObject1 != null)
        {
          localObject1 = (e[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject2).length(), e.class);
          if (localObject1 != null)
          {
            localObject2 = g.DHh;
            localObject2 = MMApplicationContext.getContext();
            p.j(localObject2, "MMApplicationContext.getContext()");
            localObject2 = ((Iterable)g.gU((Context)localObject2)).iterator();
            Object localObject3;
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (k)((Iterator)localObject2).next();
              if ((p.h(((k)localObject3).typeName, "recent") ^ true))
              {
                Object localObject4 = g.DHh;
                localObject4 = MMApplicationContext.getContext();
                p.j(localObject4, "MMApplicationContext.getContext()");
                g.K((Context)localObject4, "emoji", ((k)localObject3).typeName);
              }
            }
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              localObject3 = localObject1[i];
              localObject2 = g.DHh;
              localObject2 = g.eGA();
              localObject3 = this.DHi.subSequence(((e)localObject3).start, ((e)localObject3).end).toString();
              if (localObject3 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(209143);
                throw ((Throwable)localObject1);
              }
              localObject3 = ((String)localObject3).toLowerCase();
              p.j(localObject3, "(this as java.lang.String).toLowerCase()");
              localObject2 = (fmu)((HashMap)localObject2).get(localObject3);
              if (localObject2 != null)
              {
                localObject3 = g.DHh;
                localObject3 = g.eGB();
                if (localObject3 != null)
                {
                  localObject3 = (c)((WeakReference)localObject3).get();
                  if (localObject3 != null) {
                    h.ZvG.bc((Runnable)new a((c)localObject3));
                  }
                }
                localObject3 = g.DHh;
                g.a("emoji", (fmu)localObject2);
              }
              i += 1;
            }
            AppMethodBeat.o(209143);
            return;
          }
        }
        AppMethodBeat.o(209143);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(211843);
        this.DHj.eDj();
        AppMethodBeat.o(211843);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.g
 * JD-Core Version:    0.7.0.1
 */