package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_COMM.ParasiticUnit;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_sub_get_visit_rsp
  extends JceStruct
{
  static ArrayList cache_vecAdBanner;
  static ArrayList cache_vecParasiticUnit;
  static s_visit cache_visit;
  public boolean end = true;
  public String page = "";
  public ArrayList vecAdBanner = null;
  public ArrayList vecParasiticUnit = null;
  public s_visit visit = null;
  
  public mobile_sub_get_visit_rsp() {}
  
  public mobile_sub_get_visit_rsp(s_visit params_visit, String paramString, boolean paramBoolean, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.visit = params_visit;
    this.page = paramString;
    this.end = paramBoolean;
    this.vecAdBanner = paramArrayList1;
    this.vecParasiticUnit = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_visit == null) {
      cache_visit = new s_visit();
    }
    this.visit = ((s_visit)paramJceInputStream.read(cache_visit, 0, false));
    this.page = paramJceInputStream.readString(1, false);
    this.end = paramJceInputStream.read(this.end, 2, false);
    Object localObject;
    if (cache_vecAdBanner == null)
    {
      cache_vecAdBanner = new ArrayList();
      localObject = new QueryADBannerUnit();
      cache_vecAdBanner.add(localObject);
    }
    this.vecAdBanner = ((ArrayList)paramJceInputStream.read(cache_vecAdBanner, 3, false));
    if (cache_vecParasiticUnit == null)
    {
      cache_vecParasiticUnit = new ArrayList();
      localObject = new ParasiticUnit();
      cache_vecParasiticUnit.add(localObject);
    }
    this.vecParasiticUnit = ((ArrayList)paramJceInputStream.read(cache_vecParasiticUnit, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.visit != null) {
      paramJceOutputStream.write(this.visit, 0);
    }
    if (this.page != null) {
      paramJceOutputStream.write(this.page, 1);
    }
    paramJceOutputStream.write(this.end, 2);
    if (this.vecAdBanner != null) {
      paramJceOutputStream.write(this.vecAdBanner, 3);
    }
    if (this.vecParasiticUnit != null) {
      paramJceOutputStream.write(this.vecParasiticUnit, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_visit_rsp
 * JD-Core Version:    0.7.0.1
 */