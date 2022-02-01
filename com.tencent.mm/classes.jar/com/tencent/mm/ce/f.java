package com.tencent.mm.ce;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.a;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class f
{
  private static volatile f NKW;
  public static Pattern NLl;
  private static final Comparator<a> NLm;
  private static boolean NLn;
  private final String IFy;
  public String[] NKX;
  public String[] NKY;
  public String[] NKZ;
  public String[] NLa;
  public String[] NLb;
  public String[] NLc;
  public ArrayList<SmileyInfo> NLd;
  private final Map<String, a> NLe;
  private int NLf;
  private int NLg;
  private HashMap<String, SmileyInfo> NLh;
  private SparseArray<String> NLi;
  private com.tencent.mm.b.f<String, Bitmap> NLj;
  private boolean NLk;
  private final String dFG;
  private final String gVw;
  private final String versionName;
  
  static
  {
    AppMethodBeat.i(104945);
    NKW = null;
    NLm = new Comparator() {};
    NLn = false;
    AppMethodBeat.o(104945);
  }
  
  private f(Context paramContext)
  {
    AppMethodBeat.i(104931);
    this.gVw = (com.tencent.mm.loader.j.b.aKC() + "emoji/newemoji/");
    this.IFy = "assets:///newemoji/";
    this.versionName = "config.conf";
    this.dFG = "newemoji-config.xml";
    this.NKX = null;
    this.NKY = null;
    this.NKZ = null;
    this.NLa = null;
    this.NLb = null;
    this.NLc = null;
    this.NLe = Collections.synchronizedMap(new HashMap());
    this.NLf = 100;
    this.NLg = 0;
    this.NLh = new HashMap();
    this.NLi = new SparseArray();
    this.NLj = new com.tencent.mm.memory.a.b(100, getClass());
    this.NLk = true;
    long l = System.currentTimeMillis();
    this.NKX = paramContext.getResources().getStringArray(2130903087);
    this.NKY = paramContext.getResources().getStringArray(2130903090);
    this.NKZ = paramContext.getResources().getStringArray(2130903088);
    this.NLa = paramContext.getResources().getStringArray(2130903092);
    this.NLb = paramContext.getResources().getStringArray(2130903089);
    this.NLc = paramContext.getResources().getStringArray(2130903091);
    gxV();
    Log.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104931);
  }
  
  private Drawable a(a parama)
  {
    AppMethodBeat.i(104941);
    int i = parama.pos;
    if (i >= 0) {}
    for (parama = b.gxI().Al(i);; parama = bih(parama.name))
    {
      AppMethodBeat.o(104941);
      return parama;
    }
  }
  
  private boolean a(int paramInt1, SpannableString paramSpannableString, int paramInt2)
  {
    AppMethodBeat.i(104940);
    a locala = big(paramSpannableString.subSequence(paramInt1, paramSpannableString.length()));
    if (locala != null)
    {
      Drawable localDrawable = a(locala);
      if ((localDrawable != null) && (paramInt1 <= paramSpannableString.length()) && (locala.text.length() + paramInt1 <= paramSpannableString.length()))
      {
        b.gxI().a(paramSpannableString, localDrawable, paramInt1, paramInt1 + locala.text.length(), paramInt2);
        AppMethodBeat.o(104940);
        return true;
      }
      Log.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", new Object[] { locala.toString() });
    }
    AppMethodBeat.o(104940);
    return false;
  }
  
  private Drawable bih(String paramString)
  {
    AppMethodBeat.i(104942);
    Object localObject5 = a.bbv() + paramString;
    Object localObject3 = new BitmapFactory.Options();
    Object localObject1 = (Bitmap)this.NLj.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (!this.NLk) {
        break label288;
      }
      localObject2 = s.aW("assets:///newemoji/".concat(String.valueOf(paramString)), 0, -1);
      localObject1 = localObject2;
      if (Util.isNullOrNil((byte[])localObject2))
      {
        localObject1 = localObject2;
        if (s.YS(this.gVw + paramString))
        {
          Log.w("MicroMsg.QQSmileyManager", "getQQSmileyDrawable: fallback use local");
          localObject1 = s.aW(this.gVw + paramString, 0, -1);
        }
      }
      localObject1 = MMGIFJNIFactory.Companion.decodeThumb((byte[])localObject1);
      if (localObject1 != null) {
        break label561;
      }
      Log.w("MicroMsg.QQSmileyManager", "[getQQSmileyDrawable] not exist! path:%s name:%s", new Object[] { localObject5, paramString });
      if (MMApplicationContext.isMainProcess()) {
        break label367;
      }
      Log.w("MicroMsg.QQSmileyManager", "checkUpdateRes not mm process, return");
    }
    label288:
    label561:
    for (;;)
    {
      try
      {
        localObject5 = MMApplicationContext.getContext().getAssets().open("newemoji/".concat(String.valueOf(paramString)));
        localObject2 = null;
      }
      catch (Exception localException1)
      {
        try
        {
          label367:
          ((InputStream)localObject5).close();
          AppMethodBeat.o(104942);
          throw localObject4;
          localException1 = localException1;
          Log.printErrStackTrace("MicroMsg.QQSmileyManager", localException1, "", new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          localException1.addSuppressed(localThrowable2);
          continue;
        }
        localThrowable2.close();
        continue;
        continue;
      }
      try
      {
        localObject3 = BitmapFactory.decodeStream((InputStream)localObject5, null, (BitmapFactory.Options)localObject3);
        localObject1 = localObject3;
        if (localObject5 == null) {}
      }
      catch (Throwable localThrowable1)
      {
        localObject2 = localThrowable1;
        AppMethodBeat.o(104942);
        localObject2 = localThrowable1;
        throw localThrowable1;
      }
      finally
      {
        if (localObject5 != null) {
          if (localObject2 == null) {
            continue;
          }
        }
      }
      try
      {
        ((InputStream)localObject5).close();
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          this.NLj.put(paramString, localObject1);
          localObject2 = localObject1;
        }
        paramString = new BitmapDrawable(MMApplicationContext.getContext().getResources(), (Bitmap)localObject2);
        AppMethodBeat.o(104942);
        return paramString;
      }
      catch (Exception localException2)
      {
        continue;
      }
      localObject2 = s.aW(this.gVw + paramString, 0, -1);
      localObject1 = localObject2;
      if (!Util.isNullOrNil((byte[])localObject2)) {
        break;
      }
      localObject1 = localObject2;
      if (!s.YS("assets:///newemoji/".concat(String.valueOf(paramString)))) {
        break;
      }
      Log.w("MicroMsg.QQSmileyManager", "getQQSmileyDrawable: fallback use asset");
      localObject1 = s.aW("assets:///newemoji/".concat(String.valueOf(paramString)), 0, -1);
      break;
      if (!g.aAc())
      {
        Log.w("MicroMsg.QQSmileyManager", "account not ready");
      }
      else
      {
        Log.w("MicroMsg.QQSmileyManager", "checkUpdateRes: %s", new Object[] { Boolean.valueOf(NLn) });
        if (!NLn)
        {
          NLn = true;
          com.tencent.mm.pluginsdk.j.a.a.b.gnC();
          if (s.YS(com.tencent.mm.pluginsdk.j.a.a.b.kC(37, 1)))
          {
            ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFO();
          }
          else
          {
            com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 1, -1, false);
            com.tencent.mm.pluginsdk.j.a.a.b.gnC();
            com.tencent.mm.pluginsdk.j.a.a.b.ahP(37);
          }
        }
      }
    }
  }
  
  public static f gxT()
  {
    AppMethodBeat.i(104932);
    if (NKW == null) {}
    try
    {
      if (NKW == null) {
        NKW = new f(MMApplicationContext.getContext());
      }
      f localf = NKW;
      AppMethodBeat.o(104932);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(104932);
    }
  }
  
  private int gxU()
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(104933);
        this.NLe.clear();
        if ((this.NKX != null) && (this.NKZ != null) && (this.NKX.length == this.NKZ.length))
        {
          j = this.NKX.length;
          i = 0;
          if (i >= j) {
            break label448;
          }
          String str6 = this.NKX[i];
          String str7 = this.NKZ[i];
          if ((this.NKY != null) && (this.NKY.length > i))
          {
            String str1 = this.NKY[i];
            if ((this.NLa == null) || (this.NLa.length <= i)) {
              break label424;
            }
            str3 = this.NLa[i];
            if ((this.NLb == null) || (this.NLb.length <= i)) {
              break label432;
            }
            str4 = this.NLb[i];
            if ((this.NLc == null) || (this.NLc.length <= i)) {
              break label440;
            }
            str5 = this.NLc[i];
            SmileyInfo localSmileyInfo = new SmileyInfo(str6, str1, str7, str3, str4, str5, i);
            this.NLe.put(str6, new a(i, str6, str6, ""));
            this.NLe.put(str7, new a(i, str6, str7, ""));
            this.NLe.put(str1, new a(i, str6, str1, ""));
            this.NLe.put(str3, new a(i, str6, str3, ""));
            this.NLe.put(str4, new a(i, str6, str4, ""));
            this.NLe.put(str5, new a(i, str6, str5, ""));
            this.NLh.put(str6, localSmileyInfo);
            this.NLi.put(localSmileyInfo.field_eggIndex, localSmileyInfo.field_key);
            i += 1;
            continue;
            gxX();
            AppMethodBeat.o(104933);
            return i;
          }
        }
        else
        {
          Log.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
          continue;
        }
        String str2 = "";
      }
      finally {}
      continue;
      label424:
      String str3 = "";
      continue;
      label432:
      String str4 = "";
      continue;
      label440:
      String str5 = "";
      continue;
      label448:
      i = j;
    }
  }
  
  private void gxX()
  {
    AppMethodBeat.i(199815);
    synchronized (this.NLe)
    {
      this.NLg = 0;
      this.NLf = 100;
      Iterator localIterator = this.NLe.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str != null)
        {
          int i = str.length();
          if (i > this.NLg) {
            this.NLg = i;
          }
          if (i < this.NLf) {
            this.NLf = i;
          }
        }
      }
    }
    Log.i("MicroMsg.QQSmileyManager", "checkMaxLength: %s, %s", new Object[] { Integer.valueOf(this.NLf), Integer.valueOf(this.NLg) });
    AppMethodBeat.o(199815);
  }
  
  public final Drawable a(SmileyInfo paramSmileyInfo)
  {
    AppMethodBeat.i(177039);
    int i = paramSmileyInfo.field_position;
    if (i >= 0) {}
    for (paramSmileyInfo = b.gxI().Al(i);; paramSmileyInfo = bih(paramSmileyInfo.field_fileName))
    {
      AppMethodBeat.o(177039);
      return paramSmileyInfo;
    }
  }
  
  public final SpannableString b(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104939);
    if ((paramSpannableString == null) || (paramSpannableString.length() == 0))
    {
      AppMethodBeat.o(104939);
      return paramSpannableString;
    }
    String str = paramSpannableString.toString();
    int i = 0;
    int k = -1;
    int m;
    for (;;)
    {
      int j = str.indexOf('/', k + 1);
      k = j;
      m = i;
      if (j == -1) {
        break;
      }
      k = j;
      if (j < str.length() - 1)
      {
        k = j;
        m = i;
        if (i >= paramInt2) {
          break;
        }
        k = j;
        if (a(j, paramSpannableString, paramInt1))
        {
          i += 1;
          k = j;
        }
      }
    }
    for (;;)
    {
      i = str.indexOf('[', k + 1);
      if (i == -1) {
        break;
      }
      k = i;
      if (i < str.length() - 1)
      {
        if (m >= paramInt2) {
          break;
        }
        k = i;
        if (a(i, paramSpannableString, paramInt1))
        {
          m += 1;
          k = i;
        }
      }
    }
    AppMethodBeat.o(104939);
    return paramSpannableString;
  }
  
  public final boolean bif(String paramString)
  {
    AppMethodBeat.i(104937);
    if (big(paramString) != null)
    {
      AppMethodBeat.o(104937);
      return true;
    }
    AppMethodBeat.o(104937);
    return false;
  }
  
  public final a big(String paramString)
  {
    AppMethodBeat.i(104938);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104938);
      return null;
    }
    for (;;)
    {
      synchronized (this.NLe)
      {
        int j = Math.min(this.NLg, paramString.length());
        int i = this.NLf;
        if (i <= j)
        {
          Object localObject = paramString.substring(0, i);
          localObject = (a)this.NLe.get(localObject);
          if (localObject != null)
          {
            paramString = (String)localObject;
            AppMethodBeat.o(104938);
            return paramString;
          }
          i += 1;
        }
      }
      paramString = null;
    }
  }
  
  public final SmileyInfo bii(String paramString)
  {
    AppMethodBeat.i(104943);
    if ((this.NLh != null) && (this.NLh.containsKey(paramString)))
    {
      paramString = (SmileyInfo)this.NLh.get(paramString);
      AppMethodBeat.o(104943);
      return paramString;
    }
    Log.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", new Object[] { paramString.replace("\\", "\\\\") });
    AppMethodBeat.o(104943);
    return null;
  }
  
  public final boolean gxV()
  {
    AppMethodBeat.i(104934);
    Log.i("MicroMsg.QQSmileyManager", "checkNewEmoji");
    ArrayList localArrayList = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().cFJ();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      gxW();
      AppMethodBeat.o(104934);
      return true;
    }
    gxW();
    AppMethodBeat.o(104934);
    return false;
  }
  
  public final void gxW()
  {
    long l;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(104936);
        l = System.currentTimeMillis();
        this.NLh.clear();
        this.NLi.clear();
        this.NLj.clear();
        gxU();
        int i = com.tencent.mm.emoji.e.b.EY(this.gVw + "config.conf");
        int j = com.tencent.mm.emoji.e.b.EY("assets:///newemoji/config.conf");
        Object localObject1 = this.gVw + "newemoji-config.xml";
        Log.i("MicroMsg.QQSmileyManager", "updateSmiley: local:%s, asset:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i > 0) && (i >= j) && (s.YS((String)localObject1)))
        {
          this.NLk = false;
          this.NLd = com.tencent.mm.emoji.e.b.d(new o((String)localObject1));
          Log.i("MicroMsg.QQSmileyManager", "updateSmiley: local size: %s", new Object[] { Integer.valueOf(this.NLd.size()) });
          if ((this.NLd == null) || (this.NLd.size() <= 0))
          {
            this.NLk = true;
            this.NLd = com.tencent.mm.emoji.e.b.d(new o("assets:///newemoji/newemoji-config.xml"));
            Log.i("MicroMsg.QQSmileyManager", "updateSmiley: asset size: %s", new Object[] { Integer.valueOf(this.NLd.size()) });
          }
          if ((this.NLd == null) || (this.NLd.isEmpty())) {
            break;
          }
          localObject1 = this.NLd.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label709;
          }
          SmileyInfo localSmileyInfo = (SmileyInfo)((Iterator)localObject1).next();
          this.NLh.put(localSmileyInfo.field_key, localSmileyInfo);
          this.NLi.put(localSmileyInfo.field_eggIndex, localSmileyInfo.field_key);
          this.NLe.put(localSmileyInfo.field_key, new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!Util.isNullOrNil(localSmileyInfo.field_cnValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_cnValue))) {
            this.NLe.put(localSmileyInfo.field_cnValue, new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_cnValue, localSmileyInfo.field_fileName));
          }
          if ((!Util.isNullOrNil(localSmileyInfo.field_qqValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_qqValue))) {
            this.NLe.put(localSmileyInfo.field_qqValue, new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_qqValue, localSmileyInfo.field_fileName));
          }
          if ((!Util.isNullOrNil(localSmileyInfo.field_twValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_twValue))) {
            this.NLe.put(localSmileyInfo.field_twValue, new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_twValue, localSmileyInfo.field_fileName));
          }
          if ((!Util.isNullOrNil(localSmileyInfo.field_enValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_enValue))) {
            this.NLe.put(localSmileyInfo.field_enValue, new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_enValue, localSmileyInfo.field_fileName));
          }
          if ((Util.isNullOrNil(localSmileyInfo.field_thValue)) || ("null".equalsIgnoreCase(localSmileyInfo.field_thValue))) {
            continue;
          }
          this.NLe.put(localSmileyInfo.field_thValue, new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_thValue, localSmileyInfo.field_fileName));
          continue;
        }
        this.NLd = null;
      }
      finally {}
    }
    Log.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
    label709:
    gxX();
    Log.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104936);
  }
  
  public final ArrayList<String> gxY()
  {
    AppMethodBeat.i(104944);
    ArrayList localArrayList = new ArrayList();
    if (this.NLd != null)
    {
      Iterator localIterator = this.NLd.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((SmileyInfo)localIterator.next()).field_key);
      }
    }
    AppMethodBeat.o(104944);
    return localArrayList;
  }
  
  public static final class a
  {
    public String key;
    public String name;
    public int pos;
    public String text;
    
    a(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      this.pos = paramInt;
      this.key = paramString1;
      this.text = paramString2;
      this.name = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ce.f
 * JD-Core Version:    0.7.0.1
 */