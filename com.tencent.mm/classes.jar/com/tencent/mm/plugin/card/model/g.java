package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.as;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
  extends as
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public String wtU = "";
  public String wtV = "";
  public String wtW;
  public String wtX;
  public String wtY;
  public boolean wtZ = false;
  public vp wua;
  public wh wub;
  public List<a> wuc = null;
  public List<b> wud = null;
  public int wue = 0;
  public int wuf = 0;
  public boolean wug;
  public List<c> wuh = null;
  
  static
  {
    AppMethodBeat.i(112776);
    info = as.aJm();
    AppMethodBeat.o(112776);
  }
  
  public final vp dkA()
  {
    AppMethodBeat.i(112771);
    vp localvp1;
    if (this.wua != null)
    {
      localvp1 = this.wua;
      AppMethodBeat.o(112771);
      return localvp1;
    }
    try
    {
      this.wua = ((vp)new vp().parseFrom(this.field_buttonData));
      localvp1 = this.wua;
      AppMethodBeat.o(112771);
      return localvp1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      vp localvp2 = new vp();
      AppMethodBeat.o(112771);
      return localvp2;
    }
  }
  
  public final wh dkB()
  {
    AppMethodBeat.i(112772);
    wh localwh1;
    if (this.wub != null)
    {
      localwh1 = this.wub;
      AppMethodBeat.o(112772);
      return localwh1;
    }
    try
    {
      this.wub = ((wh)new wh().parseFrom(this.field_operData));
      localwh1 = this.wub;
      AppMethodBeat.o(112772);
      return localwh1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardMsgInfo", localException, "", new Object[0]);
      wh localwh2 = new wh();
      AppMethodBeat.o(112772);
      return localwh2;
    }
  }
  
  public final void dkC()
  {
    AppMethodBeat.i(112773);
    if (this.wuc == null)
    {
      this.wuc = new ArrayList();
      if (Util.isNullOrNil(this.field_accept_buttons))
      {
        AppMethodBeat.o(112773);
        return;
      }
      Map localMap = XmlParser.parseXml(this.field_accept_buttons, "accept_buttons_list", null);
      if (localMap == null)
      {
        AppMethodBeat.o(112773);
        return;
      }
      int i = 0;
      if (i < 100)
      {
        Object localObject2 = new StringBuilder(".accept_buttons_list.accept_buttons");
        if (i > 0) {}
        for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
        {
          localObject1 = localObject1;
          localObject2 = (String)localMap.get((String)localObject1 + ".card_id");
          String str = (String)localMap.get((String)localObject1 + ".title");
          if ((Util.isNullOrNil((String)localObject2)) && (Util.isNullOrNil(str))) {
            break label440;
          }
          int j = Util.getInt((String)localMap.get((String)localObject1 + ".end_time"), 0);
          if ((j == 0) || (j > Util.nowSecond()))
          {
            localObject2 = new a();
            ((a)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
            ((a)localObject2).uCW = ((String)localMap.get((String)localObject1 + ".sub_title"));
            ((a)localObject2).wui = ((String)localMap.get((String)localObject1 + ".card_ext"));
            ((a)localObject2).cardId = ((String)localMap.get((String)localObject1 + ".card_id"));
            ((a)localObject2).wuj = Util.getInt((String)localMap.get((String)localObject1 + ".action_type"), 0);
            ((a)localObject2).endTime = j;
            this.wuc.add(localObject2);
          }
          i += 1;
          break;
        }
      }
    }
    label440:
    AppMethodBeat.o(112773);
  }
  
  public final void dkD()
  {
    AppMethodBeat.i(112774);
    if (this.wud == null)
    {
      this.wud = new ArrayList();
      if (Util.isNullOrNil(this.field_jump_buttons))
      {
        AppMethodBeat.o(112774);
        return;
      }
      Map localMap = XmlParser.parseXml(this.field_jump_buttons, "jump_buttons_list", null);
      if (localMap == null)
      {
        AppMethodBeat.o(112774);
        return;
      }
      int i = 0;
      if (i < 100)
      {
        Object localObject2 = new StringBuilder(".jump_buttons_list.jump_buttons");
        if (i > 0) {}
        for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
        {
          localObject1 = localObject1;
          if (Util.isNullOrNil((String)localMap.get((String)localObject1 + ".title"))) {
            break label299;
          }
          localObject2 = new b();
          ((b)localObject2).title = ((String)localMap.get((String)localObject1 + ".title"));
          ((b)localObject2).description = ((String)localMap.get((String)localObject1 + ".description"));
          ((b)localObject2).wul = ((String)localMap.get((String)localObject1 + ".button_wording"));
          ((b)localObject2).jump_url = ((String)localMap.get((String)localObject1 + ".jump_url"));
          this.wud.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label299:
    AppMethodBeat.o(112774);
  }
  
  public final void dkE()
  {
    AppMethodBeat.i(112775);
    if (this.wuh == null)
    {
      this.wuh = new ArrayList();
      if (Util.isNullOrNil(this.field_unavailable_qr_code_list))
      {
        AppMethodBeat.o(112775);
        return;
      }
      Map localMap = XmlParser.parseXml(this.field_unavailable_qr_code_list, "unavailable_qr_code_list", null);
      if (localMap == null)
      {
        AppMethodBeat.o(112775);
        return;
      }
      int i = 0;
      if (i < 100)
      {
        Object localObject2 = new StringBuilder(".unavailable_qr_code_list.unavailable_qr_codes");
        if (i > 0) {}
        for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
        {
          localObject1 = localObject1;
          if (Util.isNullOrNil((String)localMap.get((String)localObject1 + ".code_id"))) {
            break label207;
          }
          localObject2 = new c();
          ((c)localObject2).wum = ((String)localMap.get((String)localObject1 + ".code_id"));
          this.wuh.add(localObject2);
          i += 1;
          break;
        }
      }
    }
    label207:
    AppMethodBeat.o(112775);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final class a
  {
    public String cardId;
    public int endTime;
    public String title;
    public String uCW;
    public String wui;
    public int wuj;
    
    public a() {}
  }
  
  public final class b
  {
    public String description;
    public String jump_url;
    public String title;
    public String wul;
    
    public b() {}
  }
  
  public final class c
  {
    public String wum;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.g
 * JD-Core Version:    0.7.0.1
 */