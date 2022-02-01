package com.tencent.widget.pulltorefresh.library.extras;

import android.content.Context;
import android.media.MediaPlayer;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.OnPullEventListener;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.State;
import java.util.HashMap;

public class SoundPullEventListener
  implements PullToRefreshBase.OnPullEventListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public SoundPullEventListener(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(this.jdField_a_of_type_AndroidContentContext, paramInt);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
  }
  
  public MediaPlayer a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaPlayer;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(PullToRefreshBase.State paramState, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramState, Integer.valueOf(paramInt));
  }
  
  public final void a(PullToRefreshBase paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode)
  {
    paramPullToRefreshBase = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramState);
    if (paramPullToRefreshBase != null) {
      a(paramPullToRefreshBase.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.extras.SoundPullEventListener
 * JD-Core Version:    0.7.0.1
 */