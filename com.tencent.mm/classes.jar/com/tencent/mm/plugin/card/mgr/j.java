package com.tencent.mm.plugin.card.mgr;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class j
{
  private List<WeakReference<a>> eNV;
  public List<g> wsq;
  public int wsr;
  
  public j()
  {
    AppMethodBeat.i(112684);
    this.eNV = new ArrayList();
    this.wsq = new ArrayList();
    this.wsr = 0;
    loadFromDB();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().d(139268, null);
    if (localObject == null) {}
    for (int i = 0;; i = ((Integer)localObject).intValue())
    {
      this.wsr = i;
      AppMethodBeat.o(112684);
      return;
    }
  }
  
  public static void c(g paramg)
  {
    AppMethodBeat.i(112689);
    if (!am.dkL().insert(paramg)) {
      Log.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + paramg.field_msg_id);
    }
    AppMethodBeat.o(112689);
  }
  
  public static boolean d(g paramg)
  {
    AppMethodBeat.i(112696);
    if (paramg == null)
    {
      AppMethodBeat.o(112696);
      return false;
    }
    boolean bool = am.dkL().delete(paramg, new String[0]);
    if (!bool) {
      Log.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + paramg.field_msg_id);
    }
    AppMethodBeat.o(112696);
    return bool;
  }
  
  public static void dky()
  {
    AppMethodBeat.i(112699);
    Log.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
    ThreadPool.post(new j.1(), "clearRedDotAndWording");
    AppMethodBeat.o(112699);
  }
  
  public static String j(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(112691);
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(paramString).append(".jump_buttons");
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = localObject;
        if (Util.isNullOrNil((String)paramMap.get((String)localObject + ".title"))) {
          break label362;
        }
        localStringBuilder1.append("<jump_buttons>");
        localStringBuilder1.append("<title>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".title").toString()))) + "</title>");
        localStringBuilder1.append("<description>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".description").toString()))) + "</description>");
        localStringBuilder1.append("<button_wording>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".button_wording").toString()))) + "</button_wording>");
        localStringBuilder1.append("<jump_url>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".jump_url").toString()))) + "</jump_url>");
        localStringBuilder1.append("</jump_buttons>");
        i += 1;
        break;
      }
    }
    label362:
    paramMap = new StringBuilder();
    if (!Util.isNullOrNil(localStringBuilder1.toString()))
    {
      paramMap.append("<jump_buttons_list>");
      paramMap.append(localStringBuilder1.toString());
      paramMap.append("</jump_buttons_list>");
    }
    paramMap = paramMap.toString();
    AppMethodBeat.o(112691);
    return paramMap;
  }
  
  public static String k(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(112692);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < 100)
    {
      Object localObject2 = new StringBuilder().append(paramString).append(".accept_buttons");
      if (i > 0) {}
      for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
      {
        localObject1 = localObject1;
        localObject2 = (String)paramMap.get((String)localObject1 + ".card_id");
        String str = (String)paramMap.get((String)localObject1 + ".title");
        if ((Util.isNullOrNil((String)localObject2)) && (Util.isNullOrNil(str))) {
          break label524;
        }
        localStringBuilder.append("<accept_buttons>");
        localStringBuilder.append("<title>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".title").toString()))) + "</title>");
        localStringBuilder.append("<sub_title>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".sub_title").toString()))) + "</sub_title>");
        localStringBuilder.append("<card_id>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".card_id").toString()))) + "</card_id>");
        localStringBuilder.append("<card_ext>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".card_ext").toString()))) + "</card_ext>");
        localStringBuilder.append("<end_time>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".end_time").toString()))) + "</end_time>");
        localStringBuilder.append("<action_type>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".action_type").toString()))) + "</action_type>");
        localStringBuilder.append("</accept_buttons>");
        i += 1;
        break;
      }
    }
    label524:
    paramMap = new StringBuilder();
    if (!Util.isNullOrNil(localStringBuilder.toString()))
    {
      paramMap.append("<accept_buttons_list>");
      paramMap.append(localStringBuilder.toString());
      paramMap.append("</accept_buttons_list>");
    }
    paramMap = paramMap.toString();
    AppMethodBeat.o(112692);
    return paramMap;
  }
  
  public static String l(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(112693);
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(paramString).append(".unavailable_qr_code_list");
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = localObject;
        if (Util.isNullOrNil((String)paramMap.get((String)localObject + ".code_id"))) {
          break label185;
        }
        localStringBuilder1.append("<unavailable_qr_codes>");
        localStringBuilder1.append("<code_id>" + Util.escapeStringForXml(Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".code_id").toString()))) + "</code_id>");
        localStringBuilder1.append("</unavailable_qr_codes>");
        i += 1;
        break;
      }
    }
    label185:
    paramMap = new StringBuilder();
    if (!Util.isNullOrNil(localStringBuilder1.toString()))
    {
      paramMap.append("<unavailable_qr_code_list>");
      paramMap.append(localStringBuilder1.toString());
      paramMap.append("</unavailable_qr_code_list>");
    }
    paramMap = paramMap.toString();
    AppMethodBeat.o(112693);
    return paramMap;
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(112690);
    Cursor localCursor = am.dkL().getAll();
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      localCursor.moveToFirst();
      int i = localCursor.getColumnIndex("card_type");
      int j = localCursor.getColumnIndex("title");
      int k = localCursor.getColumnIndex("description");
      int m = localCursor.getColumnIndex("logo_url");
      int n = localCursor.getColumnIndex("time");
      int i1 = localCursor.getColumnIndex("card_id");
      int i2 = localCursor.getColumnIndex("card_tp_id");
      int i3 = localCursor.getColumnIndex("msg_id");
      int i4 = localCursor.getColumnIndex("msg_type");
      int i5 = localCursor.getColumnIndex("jump_type");
      int i6 = localCursor.getColumnIndex("url");
      int i7 = localCursor.getColumnIndex("buttonData");
      int i8 = localCursor.getColumnIndex("operData");
      int i9 = localCursor.getColumnIndex("report_scene");
      int i10 = localCursor.getColumnIndex("read_state");
      while (!localCursor.isAfterLast())
      {
        g localg = new g();
        localg.field_card_type = localCursor.getInt(i);
        localg.field_title = localCursor.getString(j);
        localg.field_description = localCursor.getString(k);
        localg.field_logo_url = localCursor.getString(m);
        localg.field_time = localCursor.getInt(n);
        localg.field_card_id = localCursor.getString(i1);
        localg.field_card_tp_id = localCursor.getString(i2);
        localg.field_msg_id = localCursor.getString(i3);
        localg.field_msg_type = localCursor.getInt(i4);
        localg.field_jump_type = localCursor.getInt(i5);
        localg.field_url = localCursor.getString(i6);
        localg.field_buttonData = localCursor.getBlob(i7);
        localg.field_operData = localCursor.getBlob(i8);
        localg.field_report_scene = localCursor.getInt(i9);
        localg.field_read_state = localCursor.getInt(i10);
        localCursor.moveToNext();
        this.wsq.add(localg);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(112690);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112687);
    if (this.eNV == null) {
      this.eNV = new ArrayList();
    }
    this.eNV.add(new WeakReference(parama));
    AppMethodBeat.o(112687);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(112685);
    if (this.eNV == null)
    {
      AppMethodBeat.o(112685);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).a(paramg);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112685);
  }
  
  public final boolean aky(String paramString)
  {
    AppMethodBeat.i(112694);
    if ((this.wsq == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(112694);
      return false;
    }
    int i = 0;
    while (i < this.wsq.size())
    {
      g localg = (g)this.wsq.get(i);
      if ((localg != null) && (localg.field_msg_id != null) && (localg.field_msg_id.equals(paramString)))
      {
        AppMethodBeat.o(112694);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(112694);
    return false;
  }
  
  public final boolean akz(String paramString)
  {
    AppMethodBeat.i(112695);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(112695);
      return false;
    }
    Object localObject;
    if ((this.wsq == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    while (localObject != null)
    {
      this.wsq.remove(localObject);
      d(localObject);
      AppMethodBeat.o(112695);
      return true;
      int i = 0;
      for (;;)
      {
        if (i >= this.wsq.size()) {
          break label117;
        }
        g localg = (g)this.wsq.get(i);
        localObject = localg;
        if (paramString.equals(localg.field_msg_id)) {
          break;
        }
        i += 1;
      }
      label117:
      localObject = null;
    }
    AppMethodBeat.o(112695);
    return false;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112688);
    if (this.eNV == null)
    {
      AppMethodBeat.o(112688);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.eNV.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.eNV.remove(localWeakReference);
          AppMethodBeat.o(112688);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112688);
  }
  
  public final void dkx()
  {
    AppMethodBeat.i(112698);
    this.wsr = 0;
    com.tencent.mm.kernel.h.baE().ban().B(139268, Integer.valueOf(this.wsr));
    AppMethodBeat.o(112698);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(112697);
    if ((this.wsq == null) || (this.wsq.isEmpty()))
    {
      AppMethodBeat.o(112697);
      return 0;
    }
    int i = this.wsq.size();
    AppMethodBeat.o(112697);
    return i;
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112686);
    if (this.eNV == null)
    {
      AppMethodBeat.o(112686);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).onChange();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112686);
  }
  
  public static abstract interface a
  {
    public abstract void a(g paramg);
    
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.j
 * JD-Core Version:    0.7.0.1
 */