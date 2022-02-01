package com.tencent.mm.cl;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a;
import com.tencent.mm.b.f;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class g
{
  private static volatile g UYC;
  public static Pattern UYR;
  private static a UYS;
  private static boolean UYT;
  private final String PzQ;
  public String[] UYD;
  public String[] UYE;
  public String[] UYF;
  public String[] UYG;
  public String[] UYH;
  public String[] UYI;
  public ArrayList<SmileyInfo> UYJ;
  private final Map<i, b> UYK;
  private int UYL;
  private int UYM;
  private HashMap<String, SmileyInfo> UYN;
  private SparseArray<String> UYO;
  private f<String, Bitmap> UYP;
  private boolean UYQ;
  private final String fyn;
  private final String jGs;
  private final String versionName;
  
  static
  {
    AppMethodBeat.i(104945);
    UYC = null;
    UYS = null;
    UYT = false;
    AppMethodBeat.o(104945);
  }
  
  private g(Context paramContext)
  {
    AppMethodBeat.i(104931);
    this.jGs = (com.tencent.mm.loader.j.b.aSE() + "emoji/newemoji/");
    this.PzQ = "assets:///newemoji/";
    this.versionName = "config.conf";
    this.fyn = "newemoji-config.xml";
    this.UYD = null;
    this.UYE = null;
    this.UYF = null;
    this.UYG = null;
    this.UYH = null;
    this.UYI = null;
    this.UYK = Collections.synchronizedMap(new HashMap());
    this.UYL = 100;
    this.UYM = 0;
    this.UYN = new HashMap();
    this.UYO = new SparseArray();
    this.UYP = new com.tencent.mm.memory.a.b(100, getClass());
    this.UYQ = true;
    if (UYS != null) {
      UYS.dead();
    }
    a locala = new a(this);
    UYS = locala;
    locala.alive();
    long l = System.currentTimeMillis();
    this.UYD = paramContext.getResources().getStringArray(a.b.smiley_values);
    this.UYE = paramContext.getResources().getStringArray(a.b.smiley_values_old);
    this.UYF = paramContext.getResources().getStringArray(a.b.smiley_values_ch);
    this.UYG = paramContext.getResources().getStringArray(a.b.smiley_values_tw);
    this.UYH = paramContext.getResources().getStringArray(a.b.smiley_values_en);
    this.UYI = paramContext.getResources().getStringArray(a.b.smiley_values_th);
    htU();
    Log.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104931);
  }
  
  private Drawable a(b paramb)
  {
    AppMethodBeat.i(104941);
    int i = paramb.pos;
    if (i >= 0) {}
    for (paramb = b.htF().ash(i);; paramb = buy(paramb.name))
    {
      AppMethodBeat.o(104941);
      return paramb;
    }
  }
  
  private boolean a(int paramInt1, Spannable paramSpannable, int paramInt2)
  {
    AppMethodBeat.i(226432);
    b localb = o(paramSpannable, paramInt1);
    if (localb != null)
    {
      Drawable localDrawable = a(localb);
      if ((localDrawable != null) && (paramInt1 <= paramSpannable.length()) && (localb.text.length() + paramInt1 <= paramSpannable.length()))
      {
        b.htF();
        b.a(paramSpannable, localDrawable, paramInt1, paramInt1 + localb.text.length(), paramInt2, true);
        AppMethodBeat.o(226432);
        return true;
      }
      Log.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", new Object[] { localb.toString() });
    }
    AppMethodBeat.o(226432);
    return false;
  }
  
  public static g htS()
  {
    AppMethodBeat.i(104932);
    if (UYC == null) {}
    try
    {
      if (UYC == null) {
        UYC = new g(MMApplicationContext.getContext());
      }
      g localg = UYC;
      AppMethodBeat.o(104932);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(104932);
    }
  }
  
  private int htT()
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(104933);
        this.UYK.clear();
        if ((this.UYD != null) && (this.UYF != null) && (this.UYD.length == this.UYF.length))
        {
          j = this.UYD.length;
          i = 0;
          if (i >= j) {
            break label490;
          }
          String str6 = this.UYD[i];
          String str7 = this.UYF[i];
          if ((this.UYE != null) && (this.UYE.length > i))
          {
            String str1 = this.UYE[i];
            if ((this.UYG == null) || (this.UYG.length <= i)) {
              break label466;
            }
            str3 = this.UYG[i];
            if ((this.UYH == null) || (this.UYH.length <= i)) {
              break label474;
            }
            str4 = this.UYH[i];
            if ((this.UYI == null) || (this.UYI.length <= i)) {
              break label482;
            }
            str5 = this.UYI[i];
            SmileyInfo localSmileyInfo = new SmileyInfo(str6, str1, str7, str3, str4, str5, i);
            this.UYK.put(new i(str6), new b(i, str6, str6, ""));
            this.UYK.put(new i(str7), new b(i, str6, str7, ""));
            this.UYK.put(new i(str1), new b(i, str6, str1, ""));
            this.UYK.put(new i(str3), new b(i, str6, str3, ""));
            this.UYK.put(new i(str4), new b(i, str6, str4, ""));
            this.UYK.put(new i(str5), new b(i, str6, str5, ""));
            this.UYN.put(str6, localSmileyInfo);
            this.UYO.put(localSmileyInfo.field_eggIndex, localSmileyInfo.field_key);
            i += 1;
            continue;
            htW();
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
      label466:
      String str3 = "";
      continue;
      label474:
      String str4 = "";
      continue;
      label482:
      String str5 = "";
      continue;
      label490:
      i = j;
    }
  }
  
  private void htW()
  {
    AppMethodBeat.i(226421);
    synchronized (this.UYK)
    {
      this.UYM = 0;
      this.UYL = 100;
      Iterator localIterator = this.UYK.keySet().iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (locali != null)
        {
          int i = locali.length();
          if (i > this.UYM) {
            this.UYM = i;
          }
          if (i < this.UYL) {
            this.UYL = i;
          }
        }
      }
    }
    Log.i("MicroMsg.QQSmileyManager", "checkMaxLength: %s, %s", new Object[] { Integer.valueOf(this.UYL), Integer.valueOf(this.UYM) });
    AppMethodBeat.o(226421);
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(226427);
    if (paramSpannable == null) {}
    for (int i = 0;; i = paramSpannable.length())
    {
      paramSpannable = a(paramSpannable, paramInt1, paramInt2, 0, i);
      AppMethodBeat.o(226427);
      return paramSpannable;
    }
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(226431);
    if ((paramSpannable == null) || (paramSpannable.length() == 0))
    {
      AppMethodBeat.o(226431);
      return paramSpannable;
    }
    String str = paramSpannable.toString();
    int i = 0;
    int j = paramInt3 - 1;
    for (;;)
    {
      int k = str.indexOf('/', j + 1);
      if ((k == -1) || (k >= paramInt4 - 1) || (i >= paramInt2)) {
        break;
      }
      j = k;
      if (a(k, paramSpannable, paramInt1))
      {
        i += 1;
        j = k;
      }
    }
    paramInt3 -= 1;
    for (;;)
    {
      j = str.indexOf('[', paramInt3 + 1);
      if ((j == -1) || (j >= paramInt4 - 1) || (i >= paramInt2)) {
        break;
      }
      paramInt3 = j;
      if (a(j, paramSpannable, paramInt1))
      {
        i += 1;
        paramInt3 = j;
      }
    }
    AppMethodBeat.o(226431);
    return paramSpannable;
  }
  
  public final boolean bux(String paramString)
  {
    AppMethodBeat.i(104937);
    if (o(paramString, 0) != null)
    {
      AppMethodBeat.o(104937);
      return true;
    }
    AppMethodBeat.o(104937);
    return false;
  }
  
  final Drawable buy(String paramString)
  {
    AppMethodBeat.i(104942);
    Object localObject5 = a.bkL() + paramString;
    Object localObject3 = new BitmapFactory.Options();
    Object localObject1 = (Bitmap)this.UYP.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (!this.UYQ) {
        break label288;
      }
      localObject2 = u.aY("assets:///newemoji/".concat(String.valueOf(paramString)), 0, -1);
      localObject1 = localObject2;
      if (Util.isNullOrNil((byte[])localObject2))
      {
        localObject1 = localObject2;
        if (u.agG(this.jGs + paramString))
        {
          Log.w("MicroMsg.QQSmileyManager", "getQQSmileyDrawable: fallback use local");
          localObject1 = u.aY(this.jGs + paramString, 0, -1);
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
          this.UYP.put(paramString, localObject1);
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
      localObject2 = u.aY(this.jGs + paramString, 0, -1);
      localObject1 = localObject2;
      if (!Util.isNullOrNil((byte[])localObject2)) {
        break;
      }
      localObject1 = localObject2;
      if (!u.agG("assets:///newemoji/".concat(String.valueOf(paramString)))) {
        break;
      }
      Log.w("MicroMsg.QQSmileyManager", "getQQSmileyDrawable: fallback use asset");
      localObject1 = u.aY("assets:///newemoji/".concat(String.valueOf(paramString)), 0, -1);
      break;
      if (!h.aHB())
      {
        Log.w("MicroMsg.QQSmileyManager", "account not ready");
      }
      else
      {
        Log.w("MicroMsg.QQSmileyManager", "checkUpdateRes: %s", new Object[] { Boolean.valueOf(UYT) });
        if (!UYT)
        {
          UYT = true;
          com.tencent.mm.pluginsdk.k.a.a.b.hii();
          if (u.agG(com.tencent.mm.pluginsdk.k.a.a.b.lV(37, 1)))
          {
            ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUt();
          }
          else
          {
            com.tencent.mm.pluginsdk.k.a.a.b.hii().g(37, 1, -1, false);
            com.tencent.mm.pluginsdk.k.a.a.b.hii();
            com.tencent.mm.pluginsdk.k.a.a.b.apP(37);
          }
        }
      }
    }
  }
  
  public final SmileyInfo buz(String paramString)
  {
    AppMethodBeat.i(104943);
    if ((this.UYN != null) && (this.UYN.containsKey(paramString)))
    {
      paramString = (SmileyInfo)this.UYN.get(paramString);
      AppMethodBeat.o(104943);
      return paramString;
    }
    Log.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", new Object[] { paramString.replace("\\", "\\\\") });
    AppMethodBeat.o(104943);
    return null;
  }
  
  public final boolean htU()
  {
    AppMethodBeat.i(104934);
    Log.i("MicroMsg.QQSmileyManager", "checkNewEmoji");
    ArrayList localArrayList = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().cUo();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      htV();
      AppMethodBeat.o(104934);
      return true;
    }
    htV();
    AppMethodBeat.o(104934);
    return false;
  }
  
  public final void htV()
  {
    long l;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(104936);
        l = System.currentTimeMillis();
        this.UYN.clear();
        this.UYO.clear();
        this.UYP.clear();
        htT();
        int i = com.tencent.mm.emoji.e.b.LR(this.jGs + "config.conf");
        int j = com.tencent.mm.emoji.e.b.LR("assets:///newemoji/config.conf");
        Object localObject1 = this.jGs + "newemoji-config.xml";
        Log.i("MicroMsg.QQSmileyManager", "updateSmiley: local:%s, asset:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i > 0) && (i >= j) && (u.agG((String)localObject1)))
        {
          this.UYQ = false;
          this.UYJ = com.tencent.mm.emoji.e.b.d(new q((String)localObject1));
          Log.i("MicroMsg.QQSmileyManager", "updateSmiley: local size: %s", new Object[] { Integer.valueOf(this.UYJ.size()) });
          if ((this.UYJ == null) || (this.UYJ.size() <= 0))
          {
            this.UYQ = true;
            this.UYJ = com.tencent.mm.emoji.e.b.d(new q("assets:///newemoji/newemoji-config.xml"));
            Log.i("MicroMsg.QQSmileyManager", "updateSmiley: asset size: %s", new Object[] { Integer.valueOf(this.UYJ.size()) });
          }
          if ((this.UYJ == null) || (this.UYJ.isEmpty())) {
            break;
          }
          localObject1 = this.UYJ.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label751;
          }
          SmileyInfo localSmileyInfo = (SmileyInfo)((Iterator)localObject1).next();
          this.UYN.put(localSmileyInfo.field_key, localSmileyInfo);
          this.UYO.put(localSmileyInfo.field_eggIndex, localSmileyInfo.field_key);
          this.UYK.put(new i(localSmileyInfo.field_key), new b(-1, localSmileyInfo.field_key, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!Util.isNullOrNil(localSmileyInfo.field_cnValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_cnValue))) {
            this.UYK.put(new i(localSmileyInfo.field_cnValue), new b(-1, localSmileyInfo.field_key, localSmileyInfo.field_cnValue, localSmileyInfo.field_fileName));
          }
          if ((!Util.isNullOrNil(localSmileyInfo.field_qqValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_qqValue))) {
            this.UYK.put(new i(localSmileyInfo.field_qqValue), new b(-1, localSmileyInfo.field_key, localSmileyInfo.field_qqValue, localSmileyInfo.field_fileName));
          }
          if ((!Util.isNullOrNil(localSmileyInfo.field_twValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_twValue))) {
            this.UYK.put(new i(localSmileyInfo.field_twValue), new b(-1, localSmileyInfo.field_key, localSmileyInfo.field_twValue, localSmileyInfo.field_fileName));
          }
          if ((!Util.isNullOrNil(localSmileyInfo.field_enValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_enValue))) {
            this.UYK.put(new i(localSmileyInfo.field_enValue), new b(-1, localSmileyInfo.field_key, localSmileyInfo.field_enValue, localSmileyInfo.field_fileName));
          }
          if ((Util.isNullOrNil(localSmileyInfo.field_thValue)) || ("null".equalsIgnoreCase(localSmileyInfo.field_thValue))) {
            continue;
          }
          this.UYK.put(new i(localSmileyInfo.field_thValue), new b(-1, localSmileyInfo.field_key, localSmileyInfo.field_thValue, localSmileyInfo.field_fileName));
          continue;
        }
        this.UYJ = null;
      }
      finally {}
    }
    Log.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
    label751:
    htW();
    Log.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104936);
  }
  
  public final ArrayList<String> htX()
  {
    AppMethodBeat.i(104944);
    ArrayList localArrayList = new ArrayList();
    if (this.UYJ != null)
    {
      Iterator localIterator = this.UYJ.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((SmileyInfo)localIterator.next()).field_key);
      }
    }
    AppMethodBeat.o(104944);
    return localArrayList;
  }
  
  public final b o(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(226426);
    if (Util.isNullOrNil(paramCharSequence))
    {
      AppMethodBeat.o(226426);
      return null;
    }
    for (;;)
    {
      synchronized (this.UYK)
      {
        int j = Math.min(this.UYM, paramCharSequence.length() - paramInt);
        int i = this.UYL;
        if (i <= j)
        {
          b localb = (b)this.UYK.get(new i(paramCharSequence, paramInt, i + paramInt));
          if (localb != null)
          {
            paramCharSequence = localb;
            AppMethodBeat.o(226426);
            return paramCharSequence;
          }
          i += 1;
        }
      }
      paramCharSequence = null;
    }
  }
  
  static final class a
    extends IListener<mv>
  {
    private final WeakReference<g> kNt;
    
    public a(g paramg)
    {
      AppMethodBeat.i(228607);
      this.kNt = new WeakReference(paramg);
      this.__eventId = mv.class.getName().hashCode();
      AppMethodBeat.o(228607);
    }
  }
  
  public static final class b
  {
    public String key;
    public String name;
    public int pos;
    public String text;
    
    b(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      this.pos = paramInt;
      this.key = paramString1;
      this.text = paramString2;
      this.name = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cl.g
 * JD-Core Version:    0.7.0.1
 */