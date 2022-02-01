package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWMDBAndroidPushRsp
  extends JceStruct
{
  static stAndroidPush cache_androidPush;
  public stAndroidPush androidPush = null;
  public int curPushVersion = 0;
  public int retAndroidPush = 0;
  
  public stWMDBAndroidPushRsp() {}
  
  public stWMDBAndroidPushRsp(int paramInt1, int paramInt2, stAndroidPush paramstAndroidPush)
  {
    this.curPushVersion = paramInt1;
    this.retAndroidPush = paramInt2;
    this.androidPush = paramstAndroidPush;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.curPushVersion = paramJceInputStream.read(this.curPushVersion, 0, true);
    this.retAndroidPush = paramJceInputStream.read(this.retAndroidPush, 1, true);
    if (cache_androidPush == null) {
      cache_androidPush = new stAndroidPush();
    }
    this.androidPush = ((stAndroidPush)paramJceInputStream.read(cache_androidPush, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.curPushVersion, 0);
    paramJceOutputStream.write(this.retAndroidPush, 1);
    paramJceOutputStream.write(this.androidPush, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     WMDBClientInterface.stWMDBAndroidPushRsp
 * JD-Core Version:    0.7.0.1
 */