import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import com.tencent.open.export.js.VipDownloadInterface;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lia
  implements DownloadQueryListener
{
  public lia(VipDownloadInterface paramVipDownloadInterface) {}
  
  public void a(int paramInt, String paramString)
  {
    LogUtility.e(this.a.a, "getQueryDownloadAction onException code = " + paramInt + " msg= ");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramString);
      paramString = "javascript:publicAccountDownload.queryProcess(" + localJSONObject.toString() + ")";
      this.a.a(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void b(List paramList)
  {
    LogUtility.a(this.a.a, "getQueryDownloadAction onResult = " + paramList.size());
    JSONArray localJSONArray = new JSONArray();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        JSONObject localJSONObject = new JSONObject();
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
        try
        {
          localJSONObject.put("appid", localDownloadInfo.b);
          localJSONObject.put("pro", localDownloadInfo.k);
          localJSONObject.put("state", localDownloadInfo.a());
          localJSONObject.put("ismyapp", localDownloadInfo.h);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    paramList = "javascript:publicAccountDownload.queryProcess(" + localJSONArray.toString() + ")";
    LogUtility.a(this.a.a, "getQueryDownloadAction callback url = " + paramList);
    this.a.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lia
 * JD-Core Version:    0.7.0.1
 */