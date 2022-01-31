package com.tencent.mm.plugin.card.b;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class k
{
  private List<WeakReference<k.a>> fKm = new ArrayList();
  public List<com.tencent.mm.plugin.card.model.g> ilf = new ArrayList();
  public int ilg = 0;
  
  public k()
  {
    loadFromDB();
    Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(139268, null);
    if (localObject == null) {}
    for (int i = 0;; i = ((Integer)localObject).intValue())
    {
      this.ilg = i;
      return;
    }
  }
  
  public static void aAg()
  {
    y.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
    com.tencent.mm.sdk.f.e.post(new k.1(), "clearRedDotAndWording");
  }
  
  public static void c(com.tencent.mm.plugin.card.model.g paramg)
  {
    if (!am.aAu().b(paramg)) {
      y.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + paramg.field_msg_id);
    }
  }
  
  public static boolean d(com.tencent.mm.plugin.card.model.g paramg)
  {
    boolean bool1 = false;
    if (paramg == null) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = am.aAu().a(paramg, new String[0]);
      bool1 = bool2;
    } while (bool2);
    y.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + paramg.field_msg_id);
    return bool2;
  }
  
  public static String h(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(paramString).append(".jump_buttons");
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = localObject;
        if (bk.bl((String)paramMap.get((String)localObject + ".title"))) {
          break label357;
        }
        localStringBuilder1.append("<jump_buttons>");
        localStringBuilder1.append("<title>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject).append(".title").toString()))) + "</title>");
        localStringBuilder1.append("<description>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject).append(".description").toString()))) + "</description>");
        localStringBuilder1.append("<button_wording>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject).append(".button_wording").toString()))) + "</button_wording>");
        localStringBuilder1.append("<jump_url>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject).append(".jump_url").toString()))) + "</jump_url>");
        localStringBuilder1.append("</jump_buttons>");
        i += 1;
        break;
      }
    }
    label357:
    paramMap = new StringBuilder();
    if (!bk.bl(localStringBuilder1.toString()))
    {
      paramMap.append("<jump_buttons_list>");
      paramMap.append(localStringBuilder1.toString());
      paramMap.append("</jump_buttons_list>");
    }
    return paramMap.toString();
  }
  
  public static String i(Map<String, String> paramMap, String paramString)
  {
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
        if ((bk.bl((String)localObject2)) && (bk.bl(str))) {
          break label519;
        }
        localStringBuilder.append("<accept_buttons>");
        localStringBuilder.append("<title>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".title").toString()))) + "</title>");
        localStringBuilder.append("<sub_title>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".sub_title").toString()))) + "</sub_title>");
        localStringBuilder.append("<card_id>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".card_id").toString()))) + "</card_id>");
        localStringBuilder.append("<card_ext>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".card_ext").toString()))) + "</card_ext>");
        localStringBuilder.append("<end_time>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".end_time").toString()))) + "</end_time>");
        localStringBuilder.append("<action_type>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject1).append(".action_type").toString()))) + "</action_type>");
        localStringBuilder.append("</accept_buttons>");
        i += 1;
        break;
      }
    }
    label519:
    paramMap = new StringBuilder();
    if (!bk.bl(localStringBuilder.toString()))
    {
      paramMap.append("<accept_buttons_list>");
      paramMap.append(localStringBuilder.toString());
      paramMap.append("</accept_buttons_list>");
    }
    return paramMap.toString();
  }
  
  public static String j(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    if (i < 100)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(paramString).append(".unavailable_qr_code_list");
      if (i > 0) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "")
      {
        localObject = localObject;
        if (bk.bl((String)paramMap.get((String)localObject + ".code_id"))) {
          break label177;
        }
        localStringBuilder1.append("<unavailable_qr_codes>");
        localStringBuilder1.append("<code_id>" + bk.ZP(bk.pm((String)paramMap.get(new StringBuilder().append((String)localObject).append(".code_id").toString()))) + "</code_id>");
        localStringBuilder1.append("</unavailable_qr_codes>");
        i += 1;
        break;
      }
    }
    label177:
    paramMap = new StringBuilder();
    if (!bk.bl(localStringBuilder1.toString()))
    {
      paramMap.append("<unavailable_qr_code_list>");
      paramMap.append(localStringBuilder1.toString());
      paramMap.append("</unavailable_qr_code_list>");
    }
    return paramMap.toString();
  }
  
  private void loadFromDB()
  {
    Cursor localCursor = am.aAu().aAn();
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
        this.ilf.add(localg);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
  }
  
  public final void a(k.a parama)
  {
    if (this.fKm == null) {
      this.fKm = new ArrayList();
    }
    if (parama != null) {
      this.fKm.add(new WeakReference(parama));
    }
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (k.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((k.a)localObject).a(paramg);
          }
        }
        i += 1;
      }
    }
  }
  
  public final void aAf()
  {
    this.ilg = 0;
    com.tencent.mm.kernel.g.DP().Dz().o(139268, Integer.valueOf(this.ilg));
  }
  
  public final void axs()
  {
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (k.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((k.a)localObject).axs();
          }
        }
        i += 1;
      }
    }
  }
  
  public final void b(k.a parama)
  {
    if ((this.fKm == null) || (parama == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        WeakReference localWeakReference = (WeakReference)this.fKm.get(i);
        if (localWeakReference != null)
        {
          k.a locala = (k.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(parama)))
          {
            this.fKm.remove(localWeakReference);
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public final boolean ye(String paramString)
  {
    if ((this.ilf == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.ilf.size())
      {
        com.tencent.mm.plugin.card.model.g localg = (com.tencent.mm.plugin.card.model.g)this.ilf.get(i);
        if ((localg != null) && (localg.field_msg_id != null) && (localg.field_msg_id.equals(paramString))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final boolean yf(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject;
      if ((this.ilf == null) || (TextUtils.isEmpty(paramString))) {
        localObject = null;
      }
      while (localObject != null)
      {
        this.ilf.remove(localObject);
        d(localObject);
        return true;
        int i = 0;
        for (;;)
        {
          if (i >= this.ilf.size()) {
            break label99;
          }
          com.tencent.mm.plugin.card.model.g localg = (com.tencent.mm.plugin.card.model.g)this.ilf.get(i);
          localObject = localg;
          if (paramString.equals(localg.field_msg_id)) {
            break;
          }
          i += 1;
        }
        label99:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.k
 * JD-Core Version:    0.7.0.1
 */