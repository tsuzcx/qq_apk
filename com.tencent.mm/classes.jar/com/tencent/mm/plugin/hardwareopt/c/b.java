package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements a<Boolean, aoy>
{
  private boolean ljA = false;
  
  public b(boolean paramBoolean)
  {
    this.ljA = paramBoolean;
  }
  
  private static String Z(LinkedList<awp> paramLinkedList)
  {
    JSONArray localJSONArray1 = new JSONArray();
    if (paramLinkedList != null)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          paramLinkedList = paramLinkedList.iterator();
          if (!paramLinkedList.hasNext()) {
            break;
          }
          Object localObject = (awp)paramLinkedList.next();
          if ((localObject == null) || (bk.bl(((awp)localObject).jkV))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("mimeName", ((awp)localObject).jkV);
          JSONArray localJSONArray2 = new JSONArray();
          if (((awp)localObject).tth != null)
          {
            localObject = ((awp)localObject).tth.iterator();
            if (((Iterator)localObject).hasNext())
            {
              localJSONArray2.put((String)((Iterator)localObject).next());
              continue;
            }
          }
          localJSONObject.put("codecName", localJSONArray2);
        }
        catch (Exception paramLinkedList)
        {
          y.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", paramLinkedList, "hy: error when build up json", new Object[0]);
          return "";
        }
        localJSONArray1.put(localJSONObject);
      }
      return localJSONArray1.toString();
    }
    y.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.b
 * JD-Core Version:    0.7.0.1
 */