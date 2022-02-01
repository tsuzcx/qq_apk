package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_recomm_action
  extends JceStruct
{
  static s_rank cache_s_app_rank;
  static ArrayList cache_userlist;
  public int actiontype = 0;
  public int allcount = 0;
  public int btn_type = 0;
  public int button_actiontype = 0;
  public String button_text = "";
  public int is_hide_action_area = 0;
  public int is_report = 0;
  public String remark = "";
  public String report_url = "";
  public s_rank s_app_rank = null;
  public ArrayList userlist = null;
  
  public cell_recomm_action() {}
  
  public cell_recomm_action(s_rank params_rank, String paramString1, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6)
  {
    this.s_app_rank = params_rank;
    this.remark = paramString1;
    this.userlist = paramArrayList;
    this.actiontype = paramInt1;
    this.btn_type = paramInt2;
    this.is_hide_action_area = paramInt3;
    this.is_report = paramInt4;
    this.report_url = paramString2;
    this.allcount = paramInt5;
    this.button_text = paramString3;
    this.button_actiontype = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_s_app_rank == null) {
      cache_s_app_rank = new s_rank();
    }
    this.s_app_rank = ((s_rank)paramJceInputStream.read(cache_s_app_rank, 0, false));
    this.remark = paramJceInputStream.readString(1, false);
    if (cache_userlist == null)
    {
      cache_userlist = new ArrayList();
      s_user locals_user = new s_user();
      cache_userlist.add(locals_user);
    }
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 2, false));
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.btn_type = paramJceInputStream.read(this.btn_type, 4, false);
    this.is_hide_action_area = paramJceInputStream.read(this.is_hide_action_area, 5, false);
    this.is_report = paramJceInputStream.read(this.is_report, 6, false);
    this.report_url = paramJceInputStream.readString(7, false);
    this.allcount = paramJceInputStream.read(this.allcount, 8, false);
    this.button_text = paramJceInputStream.readString(9, false);
    this.button_actiontype = paramJceInputStream.read(this.button_actiontype, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.s_app_rank != null) {
      paramJceOutputStream.write(this.s_app_rank, 0);
    }
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 1);
    }
    if (this.userlist != null) {
      paramJceOutputStream.write(this.userlist, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    paramJceOutputStream.write(this.btn_type, 4);
    paramJceOutputStream.write(this.is_hide_action_area, 5);
    paramJceOutputStream.write(this.is_report, 6);
    if (this.report_url != null) {
      paramJceOutputStream.write(this.report_url, 7);
    }
    paramJceOutputStream.write(this.allcount, 8);
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 9);
    }
    paramJceOutputStream.write(this.button_actiontype, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recomm_action
 * JD-Core Version:    0.7.0.1
 */