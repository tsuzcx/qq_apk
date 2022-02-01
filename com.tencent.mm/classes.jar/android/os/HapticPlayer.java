package android.os;

public class HapticPlayer
{
  private static final String TAG = "HapticPlayer";
  DynamicEffect mEffect;
  
  private HapticPlayer() {}
  
  public HapticPlayer(DynamicEffect paramDynamicEffect)
  {
    this();
    this.mEffect = paramDynamicEffect;
  }
  
  public static boolean isAvailable()
  {
    return false;
  }
  
  public void start(int paramInt) {}
  
  public void start(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void start(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void stop() {}
  
  public void updateAmplitude(int paramInt) {}
  
  public void updateFrequency(int paramInt) {}
  
  public void updateInterval(int paramInt) {}
  
  public void updateParameter(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     android.os.HapticPlayer
 * JD-Core Version:    0.7.0.1
 */