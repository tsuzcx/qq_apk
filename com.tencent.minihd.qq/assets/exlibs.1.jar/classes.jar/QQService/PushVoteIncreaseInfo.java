package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PushVoteIncreaseInfo
  extends JceStruct
{
  static ArrayList cache_vVoterList;
  public int iIncrement = 0;
  public int lTime = 0;
  public ArrayList vVoterList = null;
  
  public PushVoteIncreaseInfo() {}
  
  public PushVoteIncreaseInfo(int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.iIncrement = paramInt1;
    this.lTime = paramInt2;
    this.vVoterList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iIncrement = paramJceInputStream.read(this.iIncrement, 0, true);
    this.lTime = paramJceInputStream.read(this.lTime, 1, true);
    if (cache_vVoterList == null)
    {
      cache_vVoterList = new ArrayList();
      Visitor localVisitor = new Visitor();
      cache_vVoterList.add(localVisitor);
    }
    this.vVoterList = ((ArrayList)paramJceInputStream.read(cache_vVoterList, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iIncrement, 0);
    paramJceOutputStream.write(this.lTime, 1);
    if (this.vVoterList != null) {
      paramJceOutputStream.write(this.vVoterList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.PushVoteIncreaseInfo
 * JD-Core Version:    0.7.0.1
 */