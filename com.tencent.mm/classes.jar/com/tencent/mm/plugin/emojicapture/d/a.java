package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTSegAttr;
import com.tencent.ttpic.PTSegmentor;
import com.tencent.ttpic.PTSticker;
import com.tencent.ttpic.config.BeautyRealConfig;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.BeautyFaceList;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.filter.BeautyTransformList;
import com.tencent.ttpic.filter.BrightnessAdjustmentFilter;
import com.tencent.ttpic.filter.RemodelFilter;
import com.tencent.ttpic.filter.SmoothBFilters;
import com.tencent.ttpic.util.BeautyRealUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.view.g;
import java.util.List;
import java.util.Map;

public final class a
{
  public static boolean ENABLE_GESTURE = true;
  public static float FACE_DETECT_IMG_WIDTH = 180.0F;
  public static boolean lte = true;
  private boolean bRB;
  public int eYd;
  public int eYj;
  public int eYk;
  private int frameIndex;
  public BrightnessAdjustmentFilter ltf;
  private boolean ltg;
  public BaseFilter lth;
  private h lti;
  private h ltj;
  public com.tencent.mm.bw.a ltk;
  public int ltl;
  private byte[] ltm;
  public int ltn;
  public BeautyFaceList mBeautyFaceList;
  private h mBeautyFrame2;
  public BeautyParam mBeautyParam;
  private h mBeautyTransformCopyFrame;
  public BeautyTransformList mBeautyTransformList;
  public BaseFilter mCopyFilter;
  public PTSticker mPTSticker;
  public RemodelFilter mRemodelFilter;
  public SmoothBFilters mSmoothBFilters;
  public BaseFilter mSwapCopyFilter;
  public h[] mSwapFrames;
  private h mTempFrame;
  
  public a()
  {
    AppMethodBeat.i(2549);
    this.mSwapCopyFilter = new BaseFilter(GLSLRender.btg);
    this.ltg = true;
    this.mSwapFrames = new h[2];
    this.frameIndex = -1;
    this.bRB = false;
    try
    {
      this.lth = new BaseFilter(GLSLRender.btg);
      this.lti = new h();
      this.mCopyFilter = new BaseFilter(GLSLRender.btg);
      this.mTempFrame = new h();
      this.ltf = new BrightnessAdjustmentFilter();
      this.mSmoothBFilters = new SmoothBFilters();
      this.mBeautyFaceList = new BeautyFaceList();
      this.mRemodelFilter = new RemodelFilter();
      this.mBeautyTransformList = new BeautyTransformList();
      this.ltj = new h();
      this.mBeautyTransformCopyFrame = new h();
      this.mBeautyFrame2 = new h();
      this.mBeautyParam = new BeautyParam(true);
      this.ltk = new com.tencent.mm.bw.a('\000');
      AppMethodBeat.o(2549);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", localException, "create FilterProcess error", new Object[0]);
      d locald = d.ltx;
      d.boa();
      AppMethodBeat.o(2549);
    }
  }
  
  private void b(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    AppMethodBeat.i(2553);
    ab.i("MicroMsg.EmojiFilterProcess", "setupCosmeticsLevelInner: %s, %s", new Object[] { paramTYPE, Integer.valueOf(paramInt) });
    switch (a.1.$SwitchMap$com$tencent$ttpic$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2553);
      return;
      this.mSmoothBFilters.updateBlurAlpha(paramInt * 0.6F / 100.0F);
      if (this.mBeautyFaceList != null)
      {
        this.mBeautyFaceList.setLightRemovePouchAlpha(paramInt * 0.6F / 100.0F);
        AppMethodBeat.o(2553);
        return;
        AppMethodBeat.o(2553);
        return;
        if (this.mBeautyFaceList != null)
        {
          this.mBeautyFaceList.setRemovePounchAlpha(paramInt / 100.0F);
          AppMethodBeat.o(2553);
          return;
          if (this.mBeautyFaceList != null)
          {
            this.mBeautyFaceList.setEyeLightenAlpha(paramInt / 100.0F);
            AppMethodBeat.o(2553);
            return;
            if (this.mBeautyFaceList != null)
            {
              this.mBeautyFaceList.setToothWhitenAlpha(paramInt / 80.0F);
              AppMethodBeat.o(2553);
              return;
              this.mRemodelFilter.setParam(paramTYPE.value, paramInt);
              AppMethodBeat.o(2553);
              return;
              if ((this.mBeautyParam != null) && (this.mBeautyTransformList != null)) {
                this.mBeautyTransformList.setBeautyParam(paramTYPE.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(paramTYPE.value), paramInt, paramTYPE.value));
              }
            }
          }
        }
      }
    }
  }
  
  private boolean bnH()
  {
    return this.mPTSticker != null;
  }
  
  public final void a(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(2552);
    if (BeautyRealUtil.isCombinedType(paramTYPE.value))
    {
      paramTYPE = BeautyRealUtil.getBeautyLevels(paramTYPE.value, false);
      if (paramTYPE.containsKey(BeautyRealConfig.TYPE.BEAUTY)) {
        b(BeautyRealConfig.TYPE.BEAUTY, ((Integer)paramTYPE.get(BeautyRealConfig.TYPE.BEAUTY)).intValue());
      }
      if (paramTYPE.containsKey(BeautyRealConfig.TYPE.BASIC3)) {
        b(BeautyRealConfig.TYPE.BASIC3, ((Integer)paramTYPE.get(BeautyRealConfig.TYPE.BASIC3)).intValue());
      }
      BeautyRealConfig.TYPE[] arrayOfTYPE = BeautyRealConfig.SINGLE_TRANS_TYPE;
      int j = arrayOfTYPE.length;
      paramInt = i;
      while (paramInt < j)
      {
        BeautyRealConfig.TYPE localTYPE = arrayOfTYPE[paramInt];
        b(localTYPE, ((Integer)paramTYPE.get(localTYPE)).intValue());
        paramInt += 1;
      }
      AppMethodBeat.o(2552);
      return;
    }
    if (paramTYPE == BeautyRealConfig.TYPE.LIPS_THICKNESS)
    {
      b(paramTYPE, 0 - paramInt);
      AppMethodBeat.o(2552);
      return;
    }
    b(paramTYPE, paramInt);
    AppMethodBeat.o(2552);
  }
  
  public final void bnG()
  {
    AppMethodBeat.i(2551);
    long l = bo.yB();
    try
    {
      this.frameIndex = ((this.frameIndex + 1) % 2);
      this.lth.RenderProcess(this.eYd, this.eYj, this.eYk, -1, 1.0D, this.lti);
      localObject1 = FrameUtil.getLastRenderFrame(this.lti);
      this.mSwapCopyFilter.RenderProcess(localObject1.texture[0], this.eYj, this.eYk, -1, 0.0D, this.mSwapFrames[this.frameIndex]);
      localObject1 = this.mSwapFrames[this.frameIndex];
      if (!lte)
      {
        this.mCopyFilter.RenderProcess(localObject1.texture[0], this.eYj, this.eYk, this.ltl, 1.0D, this.mTempFrame);
        if (this.ltm != null) {
          g.a(localObject1.texture[0], this.eYj, this.eYk, this.ltm, this.ltn);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(2551);
        return;
      }
      i = VideoFilterUtil.get4DirectionAngle(this.ltk.getPhotoAngle());
      if (bnH()) {
        GLES20.glFinish();
      }
      localObject2 = this.ltk;
      if ((this.mPTSticker == null) || (!this.mPTSticker.needDetectGesture())) {
        break label878;
      }
      bool = true;
      localPTFaceAttr = ((com.tencent.mm.bw.a)localObject2).a((h)localObject1, bool, false, false, -1);
      localObject2 = PTSegmentor.getInstance();
      if ((this.mPTSticker == null) || (!this.mPTSticker.isSegmentRequired())) {
        break label884;
      }
      bool = true;
      label280:
      localPTSegAttr = ((PTSegmentor)localObject2).detectFrame((h)localObject1, (i + 360) % 360, bool);
      if (localPTFaceAttr == null) {
        break label963;
      }
      localObject1 = localPTFaceAttr.getOrigFrame();
      i = ((Integer)localPTFaceAttr.getHistogram().first).intValue();
      if (i > 40) {
        break label890;
      }
      f = 0.0F;
      label338:
      this.mBeautyFaceList.setNormalAlphaFactor(f);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        boolean bool;
        PTFaceAttr localPTFaceAttr;
        PTSegAttr localPTSegAttr;
        float f;
        int j;
        int k;
        Object localObject3;
        label878:
        label884:
        label890:
        ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", localException, "filterProcess error", new Object[0]);
        d locald = d.ltx;
        d.bob();
        continue;
        continue;
        Object localObject2 = locald;
        continue;
      }
    }
    if ((localPTFaceAttr != null) && (localPTFaceAttr.getBrightnessAdjustmentCurve() != null))
    {
      this.ltf.updateCurve(localPTFaceAttr.getBrightnessAdjustmentCurve(), true);
      this.ltf.RenderProcess(localObject1.texture[0], this.eYj, this.eYk, -1, 0.0D, this.ltj);
      localObject1 = this.ltj;
      if ((((h)localObject1).width > 0) && (((h)localObject1).height > 0) && (localPTFaceAttr != null))
      {
        localObject2 = localPTFaceAttr.getAllFacePoints();
        i = (int)(((h)localObject1).width * localPTFaceAttr.getFaceDetectScale());
        j = (int)(((h)localObject1).height * localPTFaceAttr.getFaceDetectScale());
        k = localPTFaceAttr.getRotation();
        localObject3 = this.mSmoothBFilters;
        if (!this.ltg) {}
        for (bool = true;; bool = false)
        {
          ((SmoothBFilters)localObject3).setOnlyDetFaceRectSkin(bool);
          this.mSmoothBFilters.updateAndRender((h)localObject1, this.mBeautyFrame2, (List)localObject2, i, j, k);
          localObject2 = this.mBeautyFrame2;
          localObject1 = localObject2;
          if (localPTFaceAttr != null)
          {
            this.mBeautyFaceList.updateVideoSize(this.eYj, this.eYk, localPTFaceAttr.getFaceDetectScale());
            this.mBeautyFaceList.setLightRemovePouchSkinTexture(this.mSmoothBFilters.getVarianceFrame().texture[0]);
            localObject1 = this.mBeautyFaceList.render((h)localObject2, localPTFaceAttr.getAllFacePoints());
          }
          if ((this.mBeautyTransformList == null) || (localPTFaceAttr == null)) {
            break label950;
          }
          localObject2 = localPTFaceAttr.getAllFacePoints();
          double d = localPTFaceAttr.getFaceDetectScale();
          localObject3 = localPTFaceAttr.getAllFaceAngles();
          i = localPTFaceAttr.getRotation();
          localObject1 = this.mBeautyTransformList.process((h)localObject1, (List)localObject2, d, (List)localObject3, i);
          if (localPTSegAttr.getMaskFrame() != null)
          {
            h localh = localPTSegAttr.getMaskFrame();
            this.mCopyFilter.RenderProcess(localh.texture[0], localh.width, localh.height, -1, 0.0D, this.mBeautyTransformCopyFrame);
            localPTSegAttr.setMaskFrame(this.mBeautyTransformList.process(this.mBeautyTransformCopyFrame, (List)localObject2, d, (List)localObject3, i));
          }
          localObject1 = this.mRemodelFilter.process((h)localObject1, (List)localObject2, (List)localObject3, d);
          localObject2 = localObject1;
          if (bnH())
          {
            localObject2 = localObject1;
            if (localPTFaceAttr != null)
            {
              this.mPTSticker.updateVideoSize(this.eYj, this.eYk, localPTFaceAttr.getFaceDetectScale(), localPTFaceAttr.getRotation());
              localObject1 = this.mPTSticker.processTransformRelatedFilters((h)localObject1, localPTFaceAttr, localPTSegAttr);
              localObject2 = this.mPTSticker.processStickerFilters((h)localObject1, localPTFaceAttr, localPTSegAttr);
            }
          }
          this.mCopyFilter.RenderProcess(localObject2.texture[0], this.eYj, this.eYk, this.ltl, 1.0D, this.mTempFrame);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          ab.d("MicroMsg.EmojiFilterProcess", "filterProcess: cost %s", new Object[] { Long.valueOf(bo.av(l)) });
          AppMethodBeat.o(2551);
          return;
          bool = false;
          break;
          bool = false;
          break label280;
          if (i >= 80)
          {
            f = 1.0F;
            break label338;
          }
          f = (i - 40.0F) / 40.0F;
          break label338;
        }
      }
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(2550);
    ab.i("MicroMsg.EmojiFilterProcess", "clear %s %d", new Object[] { this, Long.valueOf(Thread.currentThread().getId()) });
    for (;;)
    {
      int i;
      try
      {
        this.lth.ClearGLSL();
        this.lti.clear();
        this.mSwapCopyFilter.ClearGLSL();
        h[] arrayOfh = this.mSwapFrames;
        int j = arrayOfh.length;
        i = 0;
        if (i < j)
        {
          h localh = arrayOfh[i];
          if (localh != null) {
            localh.clear();
          }
        }
        else
        {
          this.mCopyFilter.ClearGLSL();
          this.mTempFrame.clear();
          this.ltf.ClearGLSL();
          this.mSmoothBFilters.clear();
          this.mBeautyFaceList.clear();
          this.mRemodelFilter.clear();
          this.mBeautyTransformList.clear();
          this.ltj.clear();
          this.mBeautyTransformCopyFrame.clear();
          this.mBeautyFrame2.clear();
          if (this.mPTSticker != null)
          {
            this.mPTSticker.destroy();
            this.mPTSticker = null;
          }
          this.ltk.destroy();
          PTSegmentor.getInstance().destroy();
          GLES20.glDeleteFramebuffers(1, new int[] { this.ltn }, 0);
          AppMethodBeat.o(2550);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.EmojiFilterProcess", localException, "clear error: %s", new Object[] { localException.getMessage() });
        d locald = d.ltx;
        d.boc();
        AppMethodBeat.o(2550);
        return;
      }
      i += 1;
    }
  }
  
  public final void cm(int paramInt1, int paramInt2)
  {
    this.eYj = paramInt1;
    this.eYk = paramInt2;
    com.tencent.ttpic.config.MediaConfig.VIDEO_OUTPUT_WIDTH = paramInt1;
    com.tencent.ttpic.config.MediaConfig.VIDEO_OUTPUT_HEIGHT = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.a
 * JD-Core Version:    0.7.0.1
 */