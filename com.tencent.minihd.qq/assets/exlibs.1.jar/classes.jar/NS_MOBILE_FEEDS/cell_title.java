package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_title
  extends JceStruct
{
  static ArrayList cache_talk_user_list;
  static s_user cache_user;
  static ArrayList cache_userlist;
  public int actiontype = 0;
  public int relation = 0;
  public String relation_type = "";
  public int status = 0;
  public ArrayList talk_user_list = null;
  public String title = "";
  public String titleurl = "";
  public s_user user = null;
  public int useractiontype = 5;
  public ArrayList userlist = null;
  public int usernum = 0;
  
  public cell_title() {}
  
  public cell_title(String paramString1, String paramString2, ArrayList paramArrayList1, int paramInt1, int paramInt2, s_user params_user, int paramInt3, String paramString3, int paramInt4, ArrayList paramArrayList2, int paramInt5)
  {
    this.title = paramString1;
    this.titleurl = paramString2;
    this.userlist = paramArrayList1;
    this.usernum = paramInt1;
    this.actiontype = paramInt2;
    this.user = params_user;
    this.useractiontype = paramInt3;
    this.relation_type = paramString3;
    this.status = paramInt4;
    this.talk_user_list = paramArrayList2;
    this.relation = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.titleurl = paramJceInputStream.readString(1, false);
    s_user locals_user;
    if (cache_userlist == null)
    {
      cache_userlist = new ArrayList();
      locals_user = new s_user();
      cache_userlist.add(locals_user);
    }
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 2, false));
    this.usernum = paramJceInputStream.read(this.usernum, 3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    if (cache_user == null) {
      cache_user = new s_user();
    }
    this.user = ((s_user)paramJceInputStream.read(cache_user, 5, false));
    this.useractiontype = paramJceInputStream.read(this.useractiontype, 6, false);
    this.relation_type = paramJceInputStream.readString(7, false);
    this.status = paramJceInputStream.read(this.status, 8, false);
    if (cache_talk_user_list == null)
    {
      cache_talk_user_list = new ArrayList();
      locals_user = new s_user();
      cache_talk_user_list.add(locals_user);
    }
    this.talk_user_list = ((ArrayList)paramJceInputStream.read(cache_talk_user_list, 9, false));
    this.relation = paramJceInputStream.read(this.relation, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.titleurl != null) {
      paramJceOutputStream.write(this.titleurl, 1);
    }
    if (this.userlist != null) {
      paramJceOutputStream.write(this.userlist, 2);
    }
    paramJceOutputStream.write(this.usernum, 3);
    paramJceOutputStream.write(this.actiontype, 4);
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 5);
    }
    paramJceOutputStream.write(this.useractiontype, 6);
    if (this.relation_type != null) {
      paramJceOutputStream.write(this.relation_type, 7);
    }
    paramJceOutputStream.write(this.status, 8);
    if (this.talk_user_list != null) {
      paramJceOutputStream.write(this.talk_user_list, 9);
    }
    paramJceOutputStream.write(this.relation, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_title
 * JD-Core Version:    0.7.0.1
 */