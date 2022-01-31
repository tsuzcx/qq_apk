package com.tencent.mm.plugin.card.b;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class k
{
  private List<WeakReference<k.a>> kkV;
  public List<com.tencent.mm.plugin.card.model.g> kmd;
  public int kme;
  
  public k()
  {
    AppMethodBeat.i(87740);
    this.kkV = new ArrayList();
    this.kmd = new ArrayList();
    this.kme = 0;
    loadFromDB();
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(139268, null);
    if (localObject == null) {}
    for (int i = 0;; i = ((Integer)localObject).intValue())
    {
      this.kme = i;
      AppMethodBeat.o(87740);
      return;
    }
  }
  
  public static void bbS()
  {
    AppMethodBeat.i(87755);
    ab.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
    d.post(new k.1(), "clearRedDotAndWording");
    AppMethodBeat.o(87755);
  }
  
  public static void c(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(87745);
    if (!am.bcf().insert(paramg)) {
      ab.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + paramg.field_msg_id);
    }
    AppMethodBeat.o(87745);
  }
  
  public static boolean d(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(87752);
    if (paramg == null)
    {
      AppMethodBeat.o(87752);
      return false;
    }
    boolean bool = am.bcf().delete(paramg, new String[0]);
    if (!bool) {
      ab.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + paramg.field_msg_id);
    }
    AppMethodBeat.o(87752);
    return bool;
  }
  
  public static String h(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(87747);
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(paramString).append(".jump_buttons");
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = localObject;
        if (bo.isNullOrNil((String)paramMap.get((String)localObject + ".title"))) {
          break label362;
        }
        localStringBuilder1.append("<jump_buttons>");
        localStringBuilder1.append("<title>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".title").toString()))) + "</title>");
        localStringBuilder1.append("<description>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".description").toString()))) + "</description>");
        localStringBuilder1.append("<button_wording>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".button_wording").toString()))) + "</button_wording>");
        localStringBuilder1.append("<jump_url>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".jump_url").toString()))) + "</jump_url>");
        localStringBuilder1.append("</jump_buttons>");
        i += 1;
        break;
      }
    }
    label362:
    paramMap = new StringBuilder();
    if (!bo.isNullOrNil(localStringBuilder1.toString()))
    {
      paramMap.append("<jump_buttons_list>");
      paramMap.append(localStringBuilder1.toString());
      paramMap.append("</jump_buttons_list>");
    }
    paramMap = paramMap.toString();
    AppMethodBeat.o(87747);
    return paramMap;
  }
  
  public static String i(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(87748);
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
        if ((bo.isNullOrNil((String)localObject2)) && (bo.isNullOrNil(str))) {
          break label524;
        }
        localStringBuilder.append("<accept_buttons>");
        localStringBuilder.append("<title>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".title").toString()))) + "</title>");
        localStringBuilder.append("<sub_title>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".sub_title").toString()))) + "</sub_title>");
        localStringBuilder.append("<card_id>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".card_id").toString()))) + "</card_id>");
        localStringBuilder.append("<card_ext>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".card_ext").toString()))) + "</card_ext>");
        localStringBuilder.append("<end_time>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".end_time").toString()))) + "</end_time>");
        localStringBuilder.append("<action_type>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".action_type").toString()))) + "</action_type>");
        localStringBuilder.append("</accept_buttons>");
        i += 1;
        break;
      }
    }
    label524:
    paramMap = new StringBuilder();
    if (!bo.isNullOrNil(localStringBuilder.toString()))
    {
      paramMap.append("<accept_buttons_list>");
      paramMap.append(localStringBuilder.toString());
      paramMap.append("</accept_buttons_list>");
    }
    paramMap = paramMap.toString();
    AppMethodBeat.o(87748);
    return paramMap;
  }
  
  public static String j(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(87749);
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(paramString).append(".unavailable_qr_code_list");
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = localObject;
        if (bo.isNullOrNil((String)paramMap.get((String)localObject + ".code_id"))) {
          break label184;
        }
        localStringBuilder1.append("<unavailable_qr_codes>");
        localStringBuilder1.append("<code_id>" + bo.apT(bo.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".code_id").toString()))) + "</code_id>");
        localStringBuilder1.append("</unavailable_qr_codes>");
        i += 1;
        break;
      }
    }
    label184:
    paramMap = new StringBuilder();
    if (!bo.isNullOrNil(localStringBuilder1.toString()))
    {
      paramMap.append("<unavailable_qr_code_list>");
      paramMap.append(localStringBuilder1.toString());
      paramMap.append("</unavailable_qr_code_list>");
    }
    paramMap = paramMap.toString();
    AppMethodBeat.o(87749);
    return paramMap;
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(87746);
    Cursor localCursor = am.bcf().getAll();
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
        com.tencent.mm.plugin.card.model.g localg = new com.tencent.mm.plugin.card.model.g();
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
        this.kmd.add(localg);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(87746);
  }
  
  public final boolean HF(String paramString)
  {
    AppMethodBeat.i(87750);
    if ((this.kmd == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(87750);
      return false;
    }
    int i = 0;
    while (i < this.kmd.size())
    {
      com.tencent.mm.plugin.card.model.g localg = (com.tencent.mm.plugin.card.model.g)this.kmd.get(i);
      if ((localg != null) && (localg.field_msg_id != null) && (localg.field_msg_id.equals(paramString)))
      {
        AppMethodBeat.o(87750);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(87750);
    return false;
  }
  
  public final boolean HG(String paramString)
  {
    AppMethodBeat.i(87751);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(87751);
      return false;
    }
    Object localObject;
    if ((this.kmd == null) || (TextUtils.isEmpty(paramString))) {
      localObject = null;
    }
    while (localObject != null)
    {
      this.kmd.remove(localObject);
      d(localObject);
      AppMethodBeat.o(87751);
      return true;
      int i = 0;
      for (;;)
      {
        if (i >= this.kmd.size()) {
          break label117;
        }
        com.tencent.mm.plugin.card.model.g localg = (com.tencent.mm.plugin.card.model.g)this.kmd.get(i);
        localObject = localg;
        if (paramString.equals(localg.field_msg_id)) {
          break;
        }
        i += 1;
      }
      label117:
      localObject = null;
    }
    AppMethodBeat.o(87751);
    return false;
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(87743);
    if (this.kkV == null) {
      this.kkV = new ArrayList();
    }
    this.kkV.add(new WeakReference(parama));
    AppMethodBeat.o(87743);
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(87741);
    if (this.kkV == null)
    {
      AppMethodBeat.o(87741);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (k.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((k.a)localObject).a(paramg);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87741);
  }
  
  public final void b(k.a parama)
  {
    AppMethodBeat.i(87744);
    if (this.kkV == null)
    {
      AppMethodBeat.o(87744);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.kkV.get(i);
      if (localWeakReference != null)
      {
        k.a locala = (k.a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.kkV.remove(localWeakReference);
          AppMethodBeat.o(87744);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87744);
  }
  
  public final void bbR()
  {
    AppMethodBeat.i(87754);
    this.kme = 0;
    com.tencent.mm.kernel.g.RL().Ru().set(139268, Integer.valueOf(this.kme));
    AppMethodBeat.o(87754);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(87753);
    if ((this.kmd == null) || (this.kmd.isEmpty()))
    {
      AppMethodBeat.o(87753);
      return 0;
    }
    int i = this.kmd.size();
    AppMethodBeat.o(87753);
    return i;
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(87742);
    if (this.kkV == null)
    {
      AppMethodBeat.o(87742);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (k.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((k.a)localObject).onChange();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.k
 * JD-Core Version:    0.7.0.1
 */