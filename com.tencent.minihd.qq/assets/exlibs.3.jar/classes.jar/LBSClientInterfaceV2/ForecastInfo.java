package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ForecastInfo
  extends JceStruct
{
  static Date cache__date;
  public String _ac = "";
  public String _ac_n = "";
  public String _bp = "";
  public String _bp_n = "";
  public String _bwd = "";
  public String _bwea = "";
  public String _bws = "";
  public String _cl = "";
  public String _cl_n = "";
  public String _co = "";
  public String _co_n = "";
  public String _ct = "";
  public String _ct_n = "";
  public Date _date = null;
  public String _ewd = "";
  public String _ewea = "";
  public String _ews = "";
  public String _gj = "";
  public String _gj_n = "";
  public String _gm = "";
  public String _gm_n = "";
  public String _ls = "";
  public String _ls_n = "";
  public String _pj = "";
  public String _pj_n = "";
  public String _pl = "";
  public String _pl_n = "";
  public short _tmax = 0;
  public short _tmin = 0;
  public String _tr = "";
  public String _tr_n = "";
  public String _uv = "";
  public String _uv_n = "";
  public String _xc = "";
  public String _xc_n = "";
  public String _ys = "";
  public String _ys_n = "";
  public String _zs = "";
  public String _zs_n = "";
  
  public ForecastInfo() {}
  
  public ForecastInfo(Date paramDate, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, short paramShort1, short paramShort2, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35, String paramString36)
  {
    this._date = paramDate;
    this._bwea = paramString1;
    this._ewea = paramString2;
    this._bwd = paramString3;
    this._ewd = paramString4;
    this._bws = paramString5;
    this._ews = paramString6;
    this._tmax = paramShort1;
    this._tmin = paramShort2;
    this._ct = paramString7;
    this._ct_n = paramString8;
    this._co = paramString9;
    this._co_n = paramString10;
    this._cl = paramString11;
    this._cl_n = paramString12;
    this._gm = paramString13;
    this._gm_n = paramString14;
    this._ac = paramString15;
    this._ac_n = paramString16;
    this._xc = paramString17;
    this._xc_n = paramString18;
    this._ys = paramString19;
    this._ys_n = paramString20;
    this._pl = paramString21;
    this._pl_n = paramString22;
    this._pj = paramString23;
    this._pj_n = paramString24;
    this._ls = paramString25;
    this._ls_n = paramString26;
    this._tr = paramString27;
    this._tr_n = paramString28;
    this._gj = paramString29;
    this._gj_n = paramString30;
    this._uv = paramString31;
    this._uv_n = paramString32;
    this._zs = paramString33;
    this._zs_n = paramString34;
    this._bp = paramString35;
    this._bp_n = paramString36;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache__date == null) {
      cache__date = new Date();
    }
    this._date = ((Date)paramJceInputStream.read(cache__date, 0, true));
    this._bwea = paramJceInputStream.readString(1, true);
    this._ewea = paramJceInputStream.readString(2, true);
    this._bwd = paramJceInputStream.readString(3, true);
    this._ewd = paramJceInputStream.readString(4, true);
    this._bws = paramJceInputStream.readString(5, true);
    this._ews = paramJceInputStream.readString(6, true);
    this._tmax = paramJceInputStream.read(this._tmax, 7, true);
    this._tmin = paramJceInputStream.read(this._tmin, 8, true);
    this._ct = paramJceInputStream.readString(9, true);
    this._ct_n = paramJceInputStream.readString(10, true);
    this._co = paramJceInputStream.readString(11, true);
    this._co_n = paramJceInputStream.readString(12, true);
    this._cl = paramJceInputStream.readString(13, true);
    this._cl_n = paramJceInputStream.readString(14, true);
    this._gm = paramJceInputStream.readString(15, true);
    this._gm_n = paramJceInputStream.readString(16, true);
    this._ac = paramJceInputStream.readString(17, true);
    this._ac_n = paramJceInputStream.readString(18, true);
    this._xc = paramJceInputStream.readString(19, true);
    this._xc_n = paramJceInputStream.readString(20, true);
    this._ys = paramJceInputStream.readString(21, true);
    this._ys_n = paramJceInputStream.readString(22, true);
    this._pl = paramJceInputStream.readString(23, true);
    this._pl_n = paramJceInputStream.readString(24, true);
    this._pj = paramJceInputStream.readString(25, true);
    this._pj_n = paramJceInputStream.readString(26, true);
    this._ls = paramJceInputStream.readString(27, true);
    this._ls_n = paramJceInputStream.readString(28, true);
    this._tr = paramJceInputStream.readString(29, true);
    this._tr_n = paramJceInputStream.readString(30, true);
    this._gj = paramJceInputStream.readString(31, true);
    this._gj_n = paramJceInputStream.readString(32, true);
    this._uv = paramJceInputStream.readString(33, true);
    this._uv_n = paramJceInputStream.readString(34, true);
    this._zs = paramJceInputStream.readString(35, true);
    this._zs_n = paramJceInputStream.readString(36, true);
    this._bp = paramJceInputStream.readString(37, true);
    this._bp_n = paramJceInputStream.readString(38, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._date, 0);
    paramJceOutputStream.write(this._bwea, 1);
    paramJceOutputStream.write(this._ewea, 2);
    paramJceOutputStream.write(this._bwd, 3);
    paramJceOutputStream.write(this._ewd, 4);
    paramJceOutputStream.write(this._bws, 5);
    paramJceOutputStream.write(this._ews, 6);
    paramJceOutputStream.write(this._tmax, 7);
    paramJceOutputStream.write(this._tmin, 8);
    paramJceOutputStream.write(this._ct, 9);
    paramJceOutputStream.write(this._ct_n, 10);
    paramJceOutputStream.write(this._co, 11);
    paramJceOutputStream.write(this._co_n, 12);
    paramJceOutputStream.write(this._cl, 13);
    paramJceOutputStream.write(this._cl_n, 14);
    paramJceOutputStream.write(this._gm, 15);
    paramJceOutputStream.write(this._gm_n, 16);
    paramJceOutputStream.write(this._ac, 17);
    paramJceOutputStream.write(this._ac_n, 18);
    paramJceOutputStream.write(this._xc, 19);
    paramJceOutputStream.write(this._xc_n, 20);
    paramJceOutputStream.write(this._ys, 21);
    paramJceOutputStream.write(this._ys_n, 22);
    paramJceOutputStream.write(this._pl, 23);
    paramJceOutputStream.write(this._pl_n, 24);
    paramJceOutputStream.write(this._pj, 25);
    paramJceOutputStream.write(this._pj_n, 26);
    paramJceOutputStream.write(this._ls, 27);
    paramJceOutputStream.write(this._ls_n, 28);
    paramJceOutputStream.write(this._tr, 29);
    paramJceOutputStream.write(this._tr_n, 30);
    paramJceOutputStream.write(this._gj, 31);
    paramJceOutputStream.write(this._gj_n, 32);
    paramJceOutputStream.write(this._uv, 33);
    paramJceOutputStream.write(this._uv_n, 34);
    paramJceOutputStream.write(this._zs, 35);
    paramJceOutputStream.write(this._zs_n, 36);
    paramJceOutputStream.write(this._bp, 37);
    paramJceOutputStream.write(this._bp_n, 38);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.ForecastInfo
 * JD-Core Version:    0.7.0.1
 */