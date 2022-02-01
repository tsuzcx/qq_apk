package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_MUSIC.MusicInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_main_page_rsp
  extends JceStruct
{
  static ArrayList cache_all_acc;
  static ArrayList cache_all_music_list;
  static s_appinfo cache_appinfo;
  static s_birthday cache_birthday;
  static s_count cache_count;
  static s_flower cache_flower;
  static s_friend_ship cache_friend_ship;
  static s_friendreq cache_friendreq;
  static s_game cache_game;
  static s_gift cache_gift;
  static s_main_page cache_mainpage;
  static s_mayknow cache_mayknow;
  static s_part_error cache_part_error;
  static s_rec_photo_list cache_photos;
  static ArrayList cache_photos_buf;
  static s_profile cache_profile;
  static s_read_space cache_readspace;
  static ArrayList cache_recent_photos;
  static Map cache_redinfo;
  static s_special cache_special;
  static s_visit cache_visit;
  static s_visit cache_visit_no_right;
  public ArrayList all_acc = null;
  public ArrayList all_music_list = null;
  public int all_music_nums = 0;
  public s_appinfo appinfo = null;
  public String attach_info = "";
  public s_birthday birthday = null;
  public s_count count = null;
  public s_flower flower = null;
  public s_friend_ship friend_ship = null;
  public s_friendreq friendreq = null;
  public s_game game = null;
  public s_gift gift = null;
  public byte green_diamond_flag = 0;
  public s_main_page mainpage = null;
  public s_mayknow mayknow = null;
  public boolean music_can_play = true;
  public int no_update = 0;
  public s_part_error part_error = null;
  public s_rec_photo_list photos = null;
  public ArrayList photos_buf = null;
  public byte play_mode_flag = 0;
  public s_profile profile = null;
  public s_read_space readspace = null;
  public ArrayList recent_photos = null;
  public Map redinfo = null;
  public s_special special = null;
  public long uWanBaNew = 0L;
  public s_visit visit = null;
  public s_visit visit_no_right = null;
  public byte wifi_auto_play = 0;
  
  public mobile_main_page_rsp() {}
  
  public mobile_main_page_rsp(s_main_page params_main_page, s_profile params_profile, s_count params_count, s_visit params_visit1, s_birthday params_birthday, s_gift params_gift, s_friendreq params_friendreq, s_special params_special, s_mayknow params_mayknow, s_part_error params_part_error, s_appinfo params_appinfo, s_rec_photo_list params_rec_photo_list, s_visit params_visit2, ArrayList paramArrayList1, ArrayList paramArrayList2, s_read_space params_read_space, String paramString, int paramInt1, s_flower params_flower, s_game params_game, Map paramMap, long paramLong, s_friend_ship params_friend_ship, byte paramByte1, boolean paramBoolean, int paramInt2, ArrayList paramArrayList3, ArrayList paramArrayList4, byte paramByte2, byte paramByte3)
  {
    this.mainpage = params_main_page;
    this.profile = params_profile;
    this.count = params_count;
    this.visit = params_visit1;
    this.birthday = params_birthday;
    this.gift = params_gift;
    this.friendreq = params_friendreq;
    this.special = params_special;
    this.mayknow = params_mayknow;
    this.part_error = params_part_error;
    this.appinfo = params_appinfo;
    this.photos = params_rec_photo_list;
    this.visit_no_right = params_visit2;
    this.photos_buf = paramArrayList1;
    this.recent_photos = paramArrayList2;
    this.readspace = params_read_space;
    this.attach_info = paramString;
    this.no_update = paramInt1;
    this.flower = params_flower;
    this.game = params_game;
    this.redinfo = paramMap;
    this.uWanBaNew = paramLong;
    this.friend_ship = params_friend_ship;
    this.green_diamond_flag = paramByte1;
    this.music_can_play = paramBoolean;
    this.all_music_nums = paramInt2;
    this.all_music_list = paramArrayList3;
    this.all_acc = paramArrayList4;
    this.wifi_auto_play = paramByte2;
    this.play_mode_flag = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_mainpage == null) {
      cache_mainpage = new s_main_page();
    }
    this.mainpage = ((s_main_page)paramJceInputStream.read(cache_mainpage, 0, false));
    if (cache_profile == null) {
      cache_profile = new s_profile();
    }
    this.profile = ((s_profile)paramJceInputStream.read(cache_profile, 1, false));
    if (cache_count == null) {
      cache_count = new s_count();
    }
    this.count = ((s_count)paramJceInputStream.read(cache_count, 2, false));
    if (cache_visit == null) {
      cache_visit = new s_visit();
    }
    this.visit = ((s_visit)paramJceInputStream.read(cache_visit, 3, false));
    if (cache_birthday == null) {
      cache_birthday = new s_birthday();
    }
    this.birthday = ((s_birthday)paramJceInputStream.read(cache_birthday, 4, false));
    if (cache_gift == null) {
      cache_gift = new s_gift();
    }
    this.gift = ((s_gift)paramJceInputStream.read(cache_gift, 5, false));
    if (cache_friendreq == null) {
      cache_friendreq = new s_friendreq();
    }
    this.friendreq = ((s_friendreq)paramJceInputStream.read(cache_friendreq, 6, false));
    if (cache_special == null) {
      cache_special = new s_special();
    }
    this.special = ((s_special)paramJceInputStream.read(cache_special, 7, false));
    if (cache_mayknow == null) {
      cache_mayknow = new s_mayknow();
    }
    this.mayknow = ((s_mayknow)paramJceInputStream.read(cache_mayknow, 8, false));
    if (cache_part_error == null) {
      cache_part_error = new s_part_error();
    }
    this.part_error = ((s_part_error)paramJceInputStream.read(cache_part_error, 9, false));
    if (cache_appinfo == null) {
      cache_appinfo = new s_appinfo();
    }
    this.appinfo = ((s_appinfo)paramJceInputStream.read(cache_appinfo, 10, false));
    if (cache_photos == null) {
      cache_photos = new s_rec_photo_list();
    }
    this.photos = ((s_rec_photo_list)paramJceInputStream.read(cache_photos, 11, false));
    if (cache_visit_no_right == null) {
      cache_visit_no_right = new s_visit();
    }
    this.visit_no_right = ((s_visit)paramJceInputStream.read(cache_visit_no_right, 12, false));
    Object localObject;
    if (cache_photos_buf == null)
    {
      cache_photos_buf = new ArrayList();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      cache_photos_buf.add(localObject);
    }
    this.photos_buf = ((ArrayList)paramJceInputStream.read(cache_photos_buf, 13, false));
    if (cache_recent_photos == null)
    {
      cache_recent_photos = new ArrayList();
      localObject = new single_feed();
      cache_recent_photos.add(localObject);
    }
    this.recent_photos = ((ArrayList)paramJceInputStream.read(cache_recent_photos, 14, false));
    if (cache_readspace == null) {
      cache_readspace = new s_read_space();
    }
    this.readspace = ((s_read_space)paramJceInputStream.read(cache_readspace, 15, false));
    this.attach_info = paramJceInputStream.readString(16, false);
    this.no_update = paramJceInputStream.read(this.no_update, 17, false);
    if (cache_flower == null) {
      cache_flower = new s_flower();
    }
    this.flower = ((s_flower)paramJceInputStream.read(cache_flower, 18, false));
    if (cache_game == null) {
      cache_game = new s_game();
    }
    this.game = ((s_game)paramJceInputStream.read(cache_game, 19, false));
    if (cache_redinfo == null)
    {
      cache_redinfo = new HashMap();
      localObject = new s_red_comm();
      cache_redinfo.put(Integer.valueOf(0), localObject);
    }
    this.redinfo = ((Map)paramJceInputStream.read(cache_redinfo, 20, false));
    this.uWanBaNew = paramJceInputStream.read(this.uWanBaNew, 21, false);
    if (cache_friend_ship == null) {
      cache_friend_ship = new s_friend_ship();
    }
    this.friend_ship = ((s_friend_ship)paramJceInputStream.read(cache_friend_ship, 22, false));
    this.green_diamond_flag = paramJceInputStream.read(this.green_diamond_flag, 23, false);
    this.music_can_play = paramJceInputStream.read(this.music_can_play, 24, false);
    this.all_music_nums = paramJceInputStream.read(this.all_music_nums, 25, false);
    if (cache_all_music_list == null)
    {
      cache_all_music_list = new ArrayList();
      localObject = new MusicInfo();
      cache_all_music_list.add(localObject);
    }
    this.all_music_list = ((ArrayList)paramJceInputStream.read(cache_all_music_list, 26, false));
    if (cache_all_acc == null)
    {
      cache_all_acc = new ArrayList();
      localObject = new s_app_acc();
      cache_all_acc.add(localObject);
    }
    this.all_acc = ((ArrayList)paramJceInputStream.read(cache_all_acc, 27, false));
    this.wifi_auto_play = paramJceInputStream.read(this.wifi_auto_play, 28, false);
    this.play_mode_flag = paramJceInputStream.read(this.play_mode_flag, 29, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mainpage != null) {
      paramJceOutputStream.write(this.mainpage, 0);
    }
    if (this.profile != null) {
      paramJceOutputStream.write(this.profile, 1);
    }
    if (this.count != null) {
      paramJceOutputStream.write(this.count, 2);
    }
    if (this.visit != null) {
      paramJceOutputStream.write(this.visit, 3);
    }
    if (this.birthday != null) {
      paramJceOutputStream.write(this.birthday, 4);
    }
    if (this.gift != null) {
      paramJceOutputStream.write(this.gift, 5);
    }
    if (this.friendreq != null) {
      paramJceOutputStream.write(this.friendreq, 6);
    }
    if (this.special != null) {
      paramJceOutputStream.write(this.special, 7);
    }
    if (this.mayknow != null) {
      paramJceOutputStream.write(this.mayknow, 8);
    }
    if (this.part_error != null) {
      paramJceOutputStream.write(this.part_error, 9);
    }
    if (this.appinfo != null) {
      paramJceOutputStream.write(this.appinfo, 10);
    }
    if (this.photos != null) {
      paramJceOutputStream.write(this.photos, 11);
    }
    if (this.visit_no_right != null) {
      paramJceOutputStream.write(this.visit_no_right, 12);
    }
    if (this.photos_buf != null) {
      paramJceOutputStream.write(this.photos_buf, 13);
    }
    if (this.recent_photos != null) {
      paramJceOutputStream.write(this.recent_photos, 14);
    }
    if (this.readspace != null) {
      paramJceOutputStream.write(this.readspace, 15);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 16);
    }
    paramJceOutputStream.write(this.no_update, 17);
    if (this.flower != null) {
      paramJceOutputStream.write(this.flower, 18);
    }
    if (this.game != null) {
      paramJceOutputStream.write(this.game, 19);
    }
    if (this.redinfo != null) {
      paramJceOutputStream.write(this.redinfo, 20);
    }
    paramJceOutputStream.write(this.uWanBaNew, 21);
    if (this.friend_ship != null) {
      paramJceOutputStream.write(this.friend_ship, 22);
    }
    paramJceOutputStream.write(this.green_diamond_flag, 23);
    paramJceOutputStream.write(this.music_can_play, 24);
    paramJceOutputStream.write(this.all_music_nums, 25);
    if (this.all_music_list != null) {
      paramJceOutputStream.write(this.all_music_list, 26);
    }
    if (this.all_acc != null) {
      paramJceOutputStream.write(this.all_acc, 27);
    }
    paramJceOutputStream.write(this.wifi_auto_play, 28);
    paramJceOutputStream.write(this.play_mode_flag, 29);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_main_page_rsp
 * JD-Core Version:    0.7.0.1
 */