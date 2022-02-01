package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class AddCardToWXCardPackage
{
  private static final String TAG = "MicroMsg.AddCardToWXCardPackage";
  
  public static class Req
    extends BaseReq
  {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3871);
      Object localObject1 = this.cardArrary;
      if ((localObject1 != null) && (((List)localObject1).size() != 0) && (this.cardArrary.size() <= 40))
      {
        localObject1 = this.cardArrary.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (AddCardToWXCardPackage.WXCardItem)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            String str = ((AddCardToWXCardPackage.WXCardItem)localObject2).cardId;
            if ((str != null) && (str.length() <= 1024))
            {
              localObject2 = ((AddCardToWXCardPackage.WXCardItem)localObject2).cardExtMsg;
              if ((localObject2 == null) || (((String)localObject2).length() <= 1024)) {
                continue;
              }
            }
          }
          AppMethodBeat.o(3871);
          return false;
        }
        AppMethodBeat.o(3871);
        return true;
      }
      AppMethodBeat.o(3871);
      return false;
    }
    
    public int getType()
    {
      return 9;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3872);
      super.toBundle(paramBundle);
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.object();
        localJSONStringer.key("card_list");
        localJSONStringer.array();
        Iterator localIterator = this.cardArrary.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject = (AddCardToWXCardPackage.WXCardItem)localIterator.next();
            localJSONStringer.object();
            localJSONStringer.key("card_id");
            localJSONStringer.value(((AddCardToWXCardPackage.WXCardItem)localObject).cardId);
            localJSONStringer.key("card_ext");
            String str2 = ((AddCardToWXCardPackage.WXCardItem)localObject).cardExtMsg;
            if (str2 == null)
            {
              localObject = "";
              localJSONStringer.value(localObject);
              localJSONStringer.endObject();
              continue;
              paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
            }
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AddCardToWXCardPackage", "Req.toBundle exception:" + localException.getMessage());
      }
      for (;;)
      {
        AppMethodBeat.o(3872);
        return;
        String str1 = localException.cardExtMsg;
        break;
        localJSONStringer.endArray();
        localJSONStringer.endObject();
      }
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3882);
      fromBundle(paramBundle);
      AppMethodBeat.o(3882);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3883);
      List localList = this.cardArrary;
      if ((localList != null) && (localList.size() != 0))
      {
        AppMethodBeat.o(3883);
        return true;
      }
      AppMethodBeat.o(3883);
      return false;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3885);
      super.fromBundle(paramBundle);
      if (this.cardArrary == null) {
        this.cardArrary = new LinkedList();
      }
      paramBundle = paramBundle.getString("_wxapi_add_card_to_wx_card_list");
      if ((paramBundle != null) && (paramBundle.length() > 0)) {
        try
        {
          paramBundle = ((JSONObject)new JSONTokener(paramBundle).nextValue()).getJSONArray("card_list");
          int i = 0;
          while (i < paramBundle.length())
          {
            JSONObject localJSONObject = paramBundle.getJSONObject(i);
            AddCardToWXCardPackage.WXCardItem localWXCardItem = new AddCardToWXCardPackage.WXCardItem();
            localWXCardItem.cardId = localJSONObject.optString("card_id");
            localWXCardItem.cardExtMsg = localJSONObject.optString("card_ext");
            localWXCardItem.cardState = localJSONObject.optInt("is_succ");
            this.cardArrary.add(localWXCardItem);
            i += 1;
          }
          AppMethodBeat.o(3885);
        }
        catch (Exception paramBundle) {}
      }
    }
    
    public int getType()
    {
      return 9;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3884);
      super.toBundle(paramBundle);
      JSONStringer localJSONStringer = new JSONStringer();
      AddCardToWXCardPackage.WXCardItem localWXCardItem;
      try
      {
        localJSONStringer.object();
        localJSONStringer.key("card_list");
        localJSONStringer.array();
        Iterator localIterator = this.cardArrary.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localWXCardItem = (AddCardToWXCardPackage.WXCardItem)localIterator.next();
            localJSONStringer.object();
            localJSONStringer.key("card_id");
            localJSONStringer.value(localWXCardItem.cardId);
            localJSONStringer.key("card_ext");
            String str1 = localWXCardItem.cardExtMsg;
            if (str1 == null)
            {
              str1 = "";
              localJSONStringer.value(str1);
              localJSONStringer.key("is_succ");
              localJSONStringer.value(localWXCardItem.cardState);
              localJSONStringer.endObject();
              continue;
              paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
            }
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AddCardToWXCardPackage", "Resp.toBundle exception:" + localException.getMessage());
      }
      for (;;)
      {
        AppMethodBeat.o(3884);
        return;
        String str2 = localWXCardItem.cardExtMsg;
        break;
        localJSONStringer.endArray();
        localJSONStringer.endObject();
      }
    }
  }
  
  public static final class WXCardItem
  {
    public String cardExtMsg;
    public String cardId;
    public int cardState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage
 * JD-Core Version:    0.7.0.1
 */