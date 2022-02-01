package com.tencent.maas.model;

import com.tencent.maas.model.time.MJTime;

public class MJMusicInfo
{
  private MJTime duration;
  private Object[] lyricObjs;
  private String musicID;
  private String singerNames;
  private String songName;
  
  public MJMusicInfo(String paramString1, String paramString2, String paramString3, MJTime paramMJTime, Object[] paramArrayOfObject)
  {
    this.musicID = paramString1;
    this.songName = paramString2;
    this.singerNames = paramString3;
    this.duration = paramMJTime;
    this.lyricObjs = paramArrayOfObject;
  }
  
  public MJTime getDuration()
  {
    return this.duration;
  }
  
  public Object[] getLyricObjs()
  {
    return this.lyricObjs;
  }
  
  public String getMusicID()
  {
    return this.musicID;
  }
  
  public String getSingerNames()
  {
    return this.singerNames;
  }
  
  public String getSongName()
  {
    return this.songName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.model.MJMusicInfo
 * JD-Core Version:    0.7.0.1
 */