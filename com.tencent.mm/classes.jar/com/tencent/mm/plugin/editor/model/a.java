package com.tencent.mm.plugin.editor.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.editor.model.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.f;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class a
{
  public static String qPd = "";
  public static HashMap<String, JSONArray> qPe = new HashMap();
  public static String qPf = ao.cVg() + "/fav_fileicon_recording.png";
  private static String qPg = ao.cVg() + "/ofm_file_icon.png";
  private static String qPh = ao.cVg() + "/app_attach_file_icon_pic.png";
  public static String qPi = ao.cVg() + "/location_msg.png";
  public static String qPj = ao.cVg() + "/note_fav_not_support.png";
  
  public static anb a(String paramString, List<d> paramList, aml paramaml)
  {
    LinkedList localLinkedList = new LinkedList();
    anb localanb = new anb();
    if (paramaml != null) {
      localLinkedList.add(paramaml);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label689;
        }
        paramaml = (d)paramString.next();
        if (paramaml != null)
        {
          if (paramaml.qPM == null) {
            break;
          }
          localLinkedList.add(paramaml.qPM);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cVj();
        paramaml = new aml();
        paramaml.ajd(8);
        paramaml.bgC("WeNoteHtmlFile");
        paramaml.At(true);
        paramaml.Mu(s.boW(paramString));
        paramaml.bgp(".htm");
        localLinkedList.add(paramaml);
        localObject1 = b.b(paramaml);
        if (!s.YS((String)localObject1)) {
          s.nw(paramString, (String)localObject1);
        }
        paramaml.bgt((String)localObject1);
      }
    }
    Object localObject1 = new aml();
    Object localObject2 = new amm();
    Object localObject3 = new amn();
    ((amn)localObject3).ajh(6);
    ((amm)localObject2).c((amn)localObject3);
    ((aml)localObject1).a((amm)localObject2);
    switch (paramaml.type)
    {
    }
    for (;;)
    {
      ((aml)localObject1).bgC(paramaml.qPN);
      localLinkedList.add(localObject1);
      break;
      ((aml)localObject1).ajd(2);
      localObject2 = (c)paramaml;
      localObject3 = ((c)localObject2).qPL;
      ((aml)localObject1).bgt((String)localObject3);
      if (!Util.isNullOrNil(((c)paramaml).dLl))
      {
        ((aml)localObject1).bgs(paramaml.dLl);
        ((aml)localObject1).bgu(((c)localObject2).dUs);
      }
      for (;;)
      {
        ((aml)localObject1).ajd(2);
        break;
        ((aml)localObject1).bgs(b.alR(localObject2.toString()));
        BitmapUtil.createThumbNail((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a((aml)localObject1), true);
        ((aml)localObject1).bgu(b.a((aml)localObject1));
      }
      ((aml)localObject1).ajd(3);
      localObject2 = (f)paramaml;
      ((aml)localObject1).bgs(paramaml.dLl);
      localObject3 = ((f)localObject2).dUs;
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((aml)localObject1).bgt((String)localObject3);
      ((aml)localObject1).ajc(((f)localObject2).dLu);
      ((aml)localObject1).At(true);
      ((aml)localObject1).bgp(((f)localObject2).qPP);
      continue;
      ((aml)localObject1).ajd(4);
      localObject2 = (l)paramaml;
      ((aml)localObject1).bgs(paramaml.dLl);
      ((aml)localObject1).bgt(((l)localObject2).dUs);
      ((aml)localObject1).bgu(((l)localObject2).thumbPath);
      localObject3 = e.aNx(((l)localObject2).dUs);
      if (localObject3 != null) {
        ((aml)localObject1).ajc(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((aml)localObject1).bgp(((l)localObject2).qPP);
        break;
        ((aml)localObject1).ajc(1);
      }
      ((aml)localObject1).ajd(1);
      ((aml)localObject1).As(true);
      ((aml)localObject1).At(true);
      localObject2 = (j)paramaml;
      ((aml)localObject1).bgs(paramaml.dLl);
      ((aml)localObject1).bgg(com.tencent.mm.plugin.editor.b.alO(((j)localObject2).content));
      if ((!Util.isNullOrNil(((aml)localObject1).desc)) && (((aml)localObject1).desc.length() > 1000)) {
        ((aml)localObject1).bgg(((aml)localObject1).desc.substring(0, 1000));
      }
    }
    label689:
    a(localLinkedList, paramList);
    localanb.bH(localLinkedList);
    return localanb;
  }
  
  private static void a(LinkedList<aml> paramLinkedList, List<d> paramList)
  {
    Log.i("MicroMsg.EditorBase", "do EditorBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        aml localaml = (aml)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (Util.isNullOrNil(localaml.KuR)))
        {
          localaml.bgs(b.alR(localaml.toString()));
          str1 = null;
          localObject = str1;
          if (i - 1 >= 0)
          {
            localObject = str1;
            if (i - 1 < paramList.size())
            {
              localObject = str1;
              if (paramList.size() > 0) {
                localObject = (d)paramList.get(i - 1);
              }
            }
          }
          if ((localObject != null) && (((d)localObject).qPN != null) && (((d)localObject).qPN.equals(localaml.Lwp))) {
            ((d)localObject).dLl = localaml.dLl;
          }
        }
        if ((i > 0) && (!Util.isNullOrNil(localaml.KuR)) && (!Util.isNullOrNil(localaml.Lvp)))
        {
          localaml.As(true);
          localaml.At(true);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("MicroMsg.EditorBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localaml.dataType) });
          localObject = localaml.LvL;
          String str2;
          if (s.YS((String)localObject))
          {
            Log.i("MicroMsg.EditorBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = s.bhK((String)localObject);
            str2 = g.getMessageDigest(s.aW((String)localObject, 0, 256));
            localaml.bgq(str1);
            localaml.bgr(str2);
            localaml.Mu(new o((String)localObject).length());
            str1 = b.b(localaml);
            boolean bool = s.YS(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localaml.Lwp))) {
              s.nw((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localaml.LvN;
            if (!s.YS((String)localObject)) {
              break label516;
            }
            Log.i("MicroMsg.EditorBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = s.bhK((String)localObject);
            str2 = g.fb((String)localObject);
            localaml.bgv(str1);
            localaml.bgw(str2);
            localaml.Mv(new o((String)localObject).length());
            str1 = b.a(localaml);
            if ((((String)localObject).equals(str1)) || (s.YS(str1))) {
              break;
            }
            s.nw((String)localObject, str1);
            break;
            Log.e("MicroMsg.EditorBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          Log.e("MicroMsg.EditorBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.a
 * JD-Core Version:    0.7.0.1
 */