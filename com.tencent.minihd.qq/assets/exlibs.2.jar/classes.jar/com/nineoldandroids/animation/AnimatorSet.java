package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet
  extends Animator
{
  private ValueAnimator mDelayAnim = null;
  private long mDuration = -1L;
  private boolean mNeedsSort = true;
  private HashMap<Animator, Node> mNodeMap = new HashMap();
  private ArrayList<Node> mNodes = new ArrayList();
  private ArrayList<Animator> mPlayingSet = new ArrayList();
  private AnimatorSetListener mSetListener = null;
  private ArrayList<Node> mSortedNodes = new ArrayList();
  private long mStartDelay = 0L;
  private boolean mStarted = false;
  boolean mTerminated = false;
  
  private void sortNodes()
  {
    int j;
    Object localObject2;
    label168:
    int m;
    if (this.mNeedsSort)
    {
      this.mSortedNodes.clear();
      localObject1 = new ArrayList();
      j = this.mNodes.size();
      i = 0;
      if (i >= j) {
        localObject2 = new ArrayList();
      }
      for (;;)
      {
        if (((ArrayList)localObject1).size() <= 0)
        {
          this.mNeedsSort = false;
          if (this.mSortedNodes.size() == this.mNodes.size()) {
            break label288;
          }
          throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
          localObject2 = (Node)this.mNodes.get(i);
          if ((((Node)localObject2).dependencies == null) || (((Node)localObject2).dependencies.size() == 0)) {
            ((ArrayList)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
        k = ((ArrayList)localObject1).size();
        i = 0;
        if (i < k) {
          break label168;
        }
        ((ArrayList)localObject1).clear();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        ((ArrayList)localObject2).clear();
      }
      Node localNode1 = (Node)((ArrayList)localObject1).get(i);
      this.mSortedNodes.add(localNode1);
      if (localNode1.nodeDependents != null)
      {
        m = localNode1.nodeDependents.size();
        j = 0;
      }
      for (;;)
      {
        if (j >= m)
        {
          i += 1;
          break;
        }
        Node localNode2 = (Node)localNode1.nodeDependents.get(j);
        localNode2.nodeDependencies.remove(localNode1);
        if (localNode2.nodeDependencies.size() == 0) {
          ((ArrayList)localObject2).add(localNode2);
        }
        j += 1;
      }
    }
    int k = this.mNodes.size();
    int i = 0;
    if (i >= k) {
      label288:
      return;
    }
    Object localObject1 = (Node)this.mNodes.get(i);
    if ((((Node)localObject1).dependencies != null) && (((Node)localObject1).dependencies.size() > 0))
    {
      m = ((Node)localObject1).dependencies.size();
      j = 0;
    }
    for (;;)
    {
      if (j >= m)
      {
        ((Node)localObject1).done = false;
        i += 1;
        break;
      }
      localObject2 = (Dependency)((Node)localObject1).dependencies.get(j);
      if (((Node)localObject1).nodeDependencies == null) {
        ((Node)localObject1).nodeDependencies = new ArrayList();
      }
      if (!((Node)localObject1).nodeDependencies.contains(((Dependency)localObject2).node)) {
        ((Node)localObject1).nodeDependencies.add(((Dependency)localObject2).node);
      }
      j += 1;
    }
  }
  
  public void cancel()
  {
    this.mTerminated = true;
    Object localObject;
    Iterator localIterator;
    if (isStarted())
    {
      localObject = null;
      if (this.mListeners != null)
      {
        localObject = (ArrayList)this.mListeners.clone();
        localIterator = ((ArrayList)localObject).iterator();
        if (localIterator.hasNext()) {
          break label94;
        }
      }
      if ((this.mDelayAnim == null) || (!this.mDelayAnim.isRunning())) {
        break label112;
      }
      this.mDelayAnim.cancel();
      label70:
      if (localObject != null) {
        localObject = ((ArrayList)localObject).iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        this.mStarted = false;
        return;
        label94:
        ((Animator.AnimatorListener)localIterator.next()).onAnimationCancel(this);
        break;
        label112:
        if (this.mSortedNodes.size() <= 0) {
          break label70;
        }
        localIterator = this.mSortedNodes.iterator();
        while (localIterator.hasNext()) {
          ((Node)localIterator.next()).animation.cancel();
        }
        break label70;
      }
      ((Animator.AnimatorListener)((Iterator)localObject).next()).onAnimationEnd(this);
    }
  }
  
  public AnimatorSet clone()
  {
    AnimatorSet localAnimatorSet = (AnimatorSet)super.clone();
    localAnimatorSet.mNeedsSort = true;
    localAnimatorSet.mTerminated = false;
    localAnimatorSet.mStarted = false;
    localAnimatorSet.mPlayingSet = new ArrayList();
    localAnimatorSet.mNodeMap = new HashMap();
    localAnimatorSet.mNodes = new ArrayList();
    localAnimatorSet.mSortedNodes = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject3 = this.mNodes.iterator();
    Object localObject1;
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = this.mNodes.iterator();
    }
    for (;;)
    {
      Object localObject4;
      if (!((Iterator)localObject1).hasNext())
      {
        return localAnimatorSet;
        localObject1 = (Node)((Iterator)localObject3).next();
        localObject2 = ((Node)localObject1).clone();
        localHashMap.put(localObject1, localObject2);
        localAnimatorSet.mNodes.add(localObject2);
        localAnimatorSet.mNodeMap.put(((Node)localObject2).animation, localObject2);
        ((Node)localObject2).dependencies = null;
        ((Node)localObject2).tmpDependencies = null;
        ((Node)localObject2).nodeDependents = null;
        ((Node)localObject2).nodeDependencies = null;
        localObject4 = ((Node)localObject2).animation.getListeners();
        if (localObject4 == null) {
          break;
        }
        localObject1 = null;
        Iterator localIterator = ((ArrayList)localObject4).iterator();
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((ArrayList)localObject4).remove((Animator.AnimatorListener)((Iterator)localObject1).next());
            }
            break;
          }
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator.next();
          if ((localAnimatorListener instanceof AnimatorSetListener))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localAnimatorListener);
            localObject1 = localObject2;
          }
        }
      }
      localObject3 = (Node)((Iterator)localObject1).next();
      Object localObject2 = (Node)localHashMap.get(localObject3);
      if (((Node)localObject3).dependencies != null)
      {
        localObject3 = ((Node)localObject3).dependencies.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Dependency)((Iterator)localObject3).next();
          ((Node)localObject2).addDependency(new Dependency((Node)localHashMap.get(((Dependency)localObject4).node), ((Dependency)localObject4).rule));
        }
      }
    }
  }
  
  public void end()
  {
    this.mTerminated = true;
    Iterator localIterator;
    if (isStarted())
    {
      if (this.mSortedNodes.size() != this.mNodes.size())
      {
        sortNodes();
        localIterator = this.mSortedNodes.iterator();
        if (localIterator.hasNext()) {
          break label127;
        }
      }
      if (this.mDelayAnim != null) {
        this.mDelayAnim.cancel();
      }
      if (this.mSortedNodes.size() > 0)
      {
        localIterator = this.mSortedNodes.iterator();
        label82:
        if (localIterator.hasNext()) {
          break label171;
        }
      }
      if (this.mListeners != null) {
        localIterator = ((ArrayList)this.mListeners.clone()).iterator();
      }
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.mStarted = false;
        return;
        label127:
        Node localNode = (Node)localIterator.next();
        if (this.mSetListener == null) {
          this.mSetListener = new AnimatorSetListener(this);
        }
        localNode.animation.addListener(this.mSetListener);
        break;
        label171:
        ((Node)localIterator.next()).animation.end();
        break label82;
      }
      ((Animator.AnimatorListener)localIterator.next()).onAnimationEnd(this);
    }
  }
  
  public ArrayList<Animator> getChildAnimations()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      localArrayList.add(((Node)localIterator.next()).animation);
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public long getStartDelay()
  {
    return this.mStartDelay;
  }
  
  public boolean isRunning()
  {
    Iterator localIterator = this.mNodes.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (!((Node)localIterator.next()).animation.isRunning());
    return true;
  }
  
  public boolean isStarted()
  {
    return this.mStarted;
  }
  
  public Builder play(Animator paramAnimator)
  {
    if (paramAnimator != null)
    {
      this.mNeedsSort = true;
      return new Builder(paramAnimator);
    }
    return null;
  }
  
  public void playSequentially(List<Animator> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.mNeedsSort = true;
      if (paramList.size() != 1) {
        break label44;
      }
      play((Animator)paramList.get(0));
    }
    for (;;)
    {
      return;
      label44:
      int i = 0;
      while (i < paramList.size() - 1)
      {
        play((Animator)paramList.get(i)).before((Animator)paramList.get(i + 1));
        i += 1;
      }
    }
  }
  
  public void playSequentially(Animator... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      this.mNeedsSort = true;
      if (paramVarArgs.length != 1) {
        break label24;
      }
      play(paramVarArgs[0]);
    }
    for (;;)
    {
      return;
      label24:
      int i = 0;
      while (i < paramVarArgs.length - 1)
      {
        play(paramVarArgs[i]).before(paramVarArgs[(i + 1)]);
        i += 1;
      }
    }
  }
  
  public void playTogether(Collection<Animator> paramCollection)
  {
    Animator localAnimator;
    Iterator localIterator;
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      this.mNeedsSort = true;
      localAnimator = null;
      localIterator = paramCollection.iterator();
      paramCollection = localAnimator;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      localAnimator = (Animator)localIterator.next();
      if (paramCollection == null) {
        paramCollection = play(localAnimator);
      } else {
        paramCollection.with(localAnimator);
      }
    }
  }
  
  public void playTogether(Animator... paramVarArgs)
  {
    Builder localBuilder;
    int i;
    if (paramVarArgs != null)
    {
      this.mNeedsSort = true;
      localBuilder = play(paramVarArgs[0]);
      i = 1;
    }
    for (;;)
    {
      if (i >= paramVarArgs.length) {
        return;
      }
      localBuilder.with(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public AnimatorSet setDuration(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("duration must be a value of zero or greater");
    }
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.mDuration = paramLong;
        return this;
      }
      ((Node)localIterator.next()).animation.setDuration(paramLong);
    }
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((Node)localIterator.next()).animation.setInterpolator(paramInterpolator);
    }
  }
  
  public void setStartDelay(long paramLong)
  {
    this.mStartDelay = paramLong;
  }
  
  public void setTarget(Object paramObject)
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Animator localAnimator = ((Node)localIterator.next()).animation;
      if ((localAnimator instanceof AnimatorSet)) {
        ((AnimatorSet)localAnimator).setTarget(paramObject);
      } else if ((localAnimator instanceof ObjectAnimator)) {
        ((ObjectAnimator)localAnimator).setTarget(paramObject);
      }
    }
  }
  
  public void setupEndValues()
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((Node)localIterator.next()).animation.setupEndValues();
    }
  }
  
  public void setupStartValues()
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((Node)localIterator.next()).animation.setupStartValues();
    }
  }
  
  public void start()
  {
    this.mTerminated = false;
    this.mStarted = true;
    sortNodes();
    int k = this.mSortedNodes.size();
    int i = 0;
    Object localObject1;
    label40:
    label61:
    label71:
    int j;
    if (i >= k)
    {
      localObject1 = new ArrayList();
      i = 0;
      if (i < k) {
        break label268;
      }
      if (this.mStartDelay > 0L) {
        break label467;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        break label431;
      }
      if (this.mListeners != null)
      {
        localObject1 = (ArrayList)this.mListeners.clone();
        j = ((ArrayList)localObject1).size();
        i = 0;
        label98:
        if (i < j) {
          break label524;
        }
      }
      if ((this.mNodes.size() == 0) && (this.mStartDelay == 0L))
      {
        this.mStarted = false;
        if (this.mListeners != null)
        {
          localObject1 = (ArrayList)this.mListeners.clone();
          j = ((ArrayList)localObject1).size();
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        return;
        localObject1 = (Node)this.mSortedNodes.get(i);
        Object localObject2 = ((Node)localObject1).animation.getListeners();
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
          localObject2 = new ArrayList((Collection)localObject2).iterator();
        }
        Object localObject3;
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext())
          {
            i += 1;
            break;
          }
          localObject3 = (Animator.AnimatorListener)((Iterator)localObject2).next();
          if (((localObject3 instanceof DependencyListener)) || ((localObject3 instanceof AnimatorSetListener))) {
            ((Node)localObject1).animation.removeListener((Animator.AnimatorListener)localObject3);
          }
        }
        label268:
        localObject2 = (Node)this.mSortedNodes.get(i);
        if (this.mSetListener == null) {
          this.mSetListener = new AnimatorSetListener(this);
        }
        if ((((Node)localObject2).dependencies == null) || (((Node)localObject2).dependencies.size() == 0))
        {
          ((ArrayList)localObject1).add(localObject2);
          ((Node)localObject2).animation.addListener(this.mSetListener);
          i += 1;
          break label40;
        }
        int m = ((Node)localObject2).dependencies.size();
        j = 0;
        for (;;)
        {
          if (j >= m)
          {
            ((Node)localObject2).tmpDependencies = ((ArrayList)((Node)localObject2).dependencies.clone());
            break;
          }
          localObject3 = (Dependency)((Node)localObject2).dependencies.get(j);
          ((Dependency)localObject3).node.animation.addListener(new DependencyListener(this, (Node)localObject2, ((Dependency)localObject3).rule));
          j += 1;
        }
        label431:
        localObject2 = (Node)((Iterator)localObject1).next();
        ((Node)localObject2).animation.start();
        this.mPlayingSet.add(((Node)localObject2).animation);
        break label61;
        label467:
        this.mDelayAnim = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        this.mDelayAnim.setDuration(this.mStartDelay);
        this.mDelayAnim.addListener(new AnimatorListenerAdapter()
        {
          boolean canceled = false;
          
          public void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            this.canceled = true;
          }
          
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            int j;
            int i;
            if (!this.canceled)
            {
              j = this.val$nodesToStart.size();
              i = 0;
            }
            for (;;)
            {
              if (i >= j) {
                return;
              }
              paramAnonymousAnimator = (AnimatorSet.Node)this.val$nodesToStart.get(i);
              paramAnonymousAnimator.animation.start();
              AnimatorSet.this.mPlayingSet.add(paramAnonymousAnimator.animation);
              i += 1;
            }
          }
        });
        this.mDelayAnim.start();
        break label71;
        label524:
        ((Animator.AnimatorListener)((ArrayList)localObject1).get(i)).onAnimationStart(this);
        i += 1;
        break label98;
      }
      ((Animator.AnimatorListener)((ArrayList)localObject1).get(i)).onAnimationEnd(this);
      i += 1;
    }
  }
  
  private class AnimatorSetListener
    implements Animator.AnimatorListener
  {
    private AnimatorSet mAnimatorSet;
    
    AnimatorSetListener(AnimatorSet paramAnimatorSet)
    {
      this.mAnimatorSet = paramAnimatorSet;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      int j;
      int i;
      if ((!AnimatorSet.this.mTerminated) && (AnimatorSet.this.mPlayingSet.size() == 0) && (AnimatorSet.this.mListeners != null))
      {
        j = AnimatorSet.this.mListeners.size();
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          return;
        }
        ((Animator.AnimatorListener)AnimatorSet.this.mListeners.get(i)).onAnimationCancel(this.mAnimatorSet);
        i += 1;
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator.removeListener(this);
      AnimatorSet.this.mPlayingSet.remove(paramAnimator);
      ((AnimatorSet.Node)this.mAnimatorSet.mNodeMap.get(paramAnimator)).done = true;
      int j;
      int i;
      if (!AnimatorSet.this.mTerminated)
      {
        paramAnimator = this.mAnimatorSet.mSortedNodes;
        j = 1;
        int k = paramAnimator.size();
        i = 0;
        if (i < k) {
          break label120;
        }
        i = j;
        label71:
        if (i != 0) {
          if (AnimatorSet.this.mListeners != null)
          {
            paramAnimator = (ArrayList)AnimatorSet.this.mListeners.clone();
            j = paramAnimator.size();
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i >= j)
        {
          this.mAnimatorSet.mStarted = false;
          return;
          label120:
          if (!((AnimatorSet.Node)paramAnimator.get(i)).done)
          {
            i = 0;
            break label71;
          }
          i += 1;
          break;
        }
        ((Animator.AnimatorListener)paramAnimator.get(i)).onAnimationEnd(this.mAnimatorSet);
        i += 1;
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  public class Builder
  {
    private AnimatorSet.Node mCurrentNode;
    
    Builder(Animator paramAnimator)
    {
      this.mCurrentNode = ((AnimatorSet.Node)AnimatorSet.this.mNodeMap.get(paramAnimator));
      if (this.mCurrentNode == null)
      {
        this.mCurrentNode = new AnimatorSet.Node(paramAnimator);
        AnimatorSet.this.mNodeMap.put(paramAnimator, this.mCurrentNode);
        AnimatorSet.this.mNodes.add(this.mCurrentNode);
      }
    }
    
    public Builder after(long paramLong)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(paramLong);
      after(localValueAnimator);
      return this;
    }
    
    public Builder after(Animator paramAnimator)
    {
      AnimatorSet.Node localNode2 = (AnimatorSet.Node)AnimatorSet.this.mNodeMap.get(paramAnimator);
      AnimatorSet.Node localNode1 = localNode2;
      if (localNode2 == null)
      {
        localNode1 = new AnimatorSet.Node(paramAnimator);
        AnimatorSet.this.mNodeMap.put(paramAnimator, localNode1);
        AnimatorSet.this.mNodes.add(localNode1);
      }
      paramAnimator = new AnimatorSet.Dependency(localNode1, 1);
      this.mCurrentNode.addDependency(paramAnimator);
      return this;
    }
    
    public Builder before(Animator paramAnimator)
    {
      AnimatorSet.Node localNode2 = (AnimatorSet.Node)AnimatorSet.this.mNodeMap.get(paramAnimator);
      AnimatorSet.Node localNode1 = localNode2;
      if (localNode2 == null)
      {
        localNode1 = new AnimatorSet.Node(paramAnimator);
        AnimatorSet.this.mNodeMap.put(paramAnimator, localNode1);
        AnimatorSet.this.mNodes.add(localNode1);
      }
      localNode1.addDependency(new AnimatorSet.Dependency(this.mCurrentNode, 1));
      return this;
    }
    
    public Builder with(Animator paramAnimator)
    {
      AnimatorSet.Node localNode2 = (AnimatorSet.Node)AnimatorSet.this.mNodeMap.get(paramAnimator);
      AnimatorSet.Node localNode1 = localNode2;
      if (localNode2 == null)
      {
        localNode1 = new AnimatorSet.Node(paramAnimator);
        AnimatorSet.this.mNodeMap.put(paramAnimator, localNode1);
        AnimatorSet.this.mNodes.add(localNode1);
      }
      localNode1.addDependency(new AnimatorSet.Dependency(this.mCurrentNode, 0));
      return this;
    }
  }
  
  private static class Dependency
  {
    static final int AFTER = 1;
    static final int WITH = 0;
    public AnimatorSet.Node node;
    public int rule;
    
    public Dependency(AnimatorSet.Node paramNode, int paramInt)
    {
      this.node = paramNode;
      this.rule = paramInt;
    }
  }
  
  private static class DependencyListener
    implements Animator.AnimatorListener
  {
    private AnimatorSet mAnimatorSet;
    private AnimatorSet.Node mNode;
    private int mRule;
    
    public DependencyListener(AnimatorSet paramAnimatorSet, AnimatorSet.Node paramNode, int paramInt)
    {
      this.mAnimatorSet = paramAnimatorSet;
      this.mNode = paramNode;
      this.mRule = paramInt;
    }
    
    private void startIfReady(Animator paramAnimator)
    {
      if (this.mAnimatorSet.mTerminated) {
        return;
      }
      Object localObject = null;
      int j = this.mNode.tmpDependencies.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {}
        for (;;)
        {
          this.mNode.tmpDependencies.remove(localObject);
          if (this.mNode.tmpDependencies.size() != 0) {
            break;
          }
          this.mNode.animation.start();
          this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
          return;
          AnimatorSet.Dependency localDependency = (AnimatorSet.Dependency)this.mNode.tmpDependencies.get(i);
          if ((localDependency.rule != this.mRule) || (localDependency.node.animation != paramAnimator)) {
            break label139;
          }
          localObject = localDependency;
          paramAnimator.removeListener(this);
        }
        label139:
        i += 1;
      }
    }
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.mRule == 1) {
        startIfReady(paramAnimator);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (this.mRule == 0) {
        startIfReady(paramAnimator);
      }
    }
  }
  
  private static class Node
    implements Cloneable
  {
    public Animator animation;
    public ArrayList<AnimatorSet.Dependency> dependencies = null;
    public boolean done = false;
    public ArrayList<Node> nodeDependencies = null;
    public ArrayList<Node> nodeDependents = null;
    public ArrayList<AnimatorSet.Dependency> tmpDependencies = null;
    
    public Node(Animator paramAnimator)
    {
      this.animation = paramAnimator;
    }
    
    public void addDependency(AnimatorSet.Dependency paramDependency)
    {
      if (this.dependencies == null)
      {
        this.dependencies = new ArrayList();
        this.nodeDependencies = new ArrayList();
      }
      this.dependencies.add(paramDependency);
      if (!this.nodeDependencies.contains(paramDependency.node)) {
        this.nodeDependencies.add(paramDependency.node);
      }
      paramDependency = paramDependency.node;
      if (paramDependency.nodeDependents == null) {
        paramDependency.nodeDependents = new ArrayList();
      }
      paramDependency.nodeDependents.add(this);
    }
    
    public Node clone()
    {
      try
      {
        Node localNode = (Node)super.clone();
        localNode.animation = this.animation.clone();
        return localNode;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet
 * JD-Core Version:    0.7.0.1
 */